package com.group.apartment.apartment.controller;

//import com.example.test.demo.domain.Employee;
import com.group.apartment.apartment.config.RestTemplateConfig;
import com.group.apartment.apartment.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path="apartment")
@Slf4j
public class ApartmentController {


    @Autowired
    RestTemplate restTemplate;

/*
    @PostMapping
    public void addApartment(final ApartmentDomain apartmentDomain){

    }
*/

    @GetMapping
    public String getTest(){
        System.out.print("I am Get Test");
        return " The App Endpoint is working";
    }

   // https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02
    //https://www.freecodeformat.com/json2pojo.php -- json to object
    // below tell why its important to create resttemplate through resttemplate builder
    //https://medium.com/@TimvanBaarsen/spring-boot-why-you-should-always-use-the-resttemplatebuilder-to-create-a-resttemplate-instance-d5a44ebad9e9
    //Welcome to Alpha Vantage! Your dedicated access key is: RNF1XG40GEP8A3IU. Please record this API key for future access to Alpha Vantage.

    //https://www.weatherapi.com/my/
    //API Key: d2bc2be3387c4046a70121047202205

    @GetMapping(path="/weather")
    public WeatherTest restTest(@RequestParam("q") String city , @RequestParam("appid")
                         String appId) throws URISyntaxException {

        String query = city;
        String key = appId;

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        //request entity is created with request headers
        HttpEntity requestEntity = new HttpEntity<>(requestHeaders);
        final String baseUrl = "https://samples.openweathermap.org/data/2.5/weather";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("q", query)
                .queryParam("appid", key);
        URI uri = new URI(baseUrl);

        ResponseEntity<WeatherTest> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                WeatherTest.class
        );
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            log.info(" Weather App The status code : {}",HttpStatus.OK);
            log.info("Response WeatherTest :{}" , responseEntity.getBody());
            log.info("Response Header info :{}" , responseEntity.getHeaders());

        }
        else{

            log.error("Weather App Error occured status{} , error{}" ,responseEntity.getStatusCode()
            ,responseEntity);
        }

        return responseEntity.getBody();

    }

    @GetMapping(path="/currency")
    public Currency getCurrency(@RequestParam("date") String date , @RequestParam("access_key")
            String appId , @RequestParam("currencies") String currencies) throws URISyntaxException {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity requestEntity = new HttpEntity<>(requestHeaders);
        final String baseUrl = "http://api.currencylayer.com/historical";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("access_key", appId)
                .queryParam("currencies", currencies)
                .queryParam("date", date);
        URI uri = new URI(baseUrl);

        ResponseEntity<Currency> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                Currency.class
        );
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            log.info(" Currency App The status code : {}",HttpStatus.OK);
            log.info("Response Currency-Test :{}" , responseEntity.getBody());
            log.info("Response Currency-Header info :{}" , responseEntity.getHeaders());

        }
        else{

            log.error("Currency App Error occured status{} , error{}" ,responseEntity.getStatusCode()
                    ,responseEntity);
        }

        return responseEntity.getBody();


    }


    @GetMapping(path="/ticketmaster/subgenres")
    public SubGenres getTicketMasterSubGenres(@RequestParam("id") String id ,
                                             @RequestParam("access_key")
            String appId) throws URISyntaxException {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity requestEntity = new HttpEntity<>(requestHeaders);
        final String baseUrl = "https://app.ticketmaster.com/discovery/v2/classifications/subgenres";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                        .path("/" +id).queryParam("apikey" ,appId);
        //URI uri = new URI(baseUrl);

        ResponseEntity<SubGenres> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                SubGenres.class
        );
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            log.info("Ticket Master App The status code : {}",HttpStatus.OK);
            log.info("Ticket Master-Test :{}" , responseEntity.getBody());
            log.info("Response Ticket Master-Header info :{}" , responseEntity.getHeaders());

        }
        else{

            log.error("Ticket Master App Error occured status{} , error{}" ,responseEntity.getStatusCode()
                    ,responseEntity);
        }

        return responseEntity.getBody();


    }

 /*   @GetMapping(path="emp")
    public Employee getEmployee(@RequestParam("name") String name ,
                                @RequestParam("job") String job){

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_XML_VALUE);

        Employee e = new Employee();
        e.setName(name);
        e.setJob(job);
        HttpEntity<Employee> requestEntity = new HttpEntity<>(e , requestHeaders);
        final String baseUrl = "http://localhost:8083/emp/employee";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                ;
        //URI uri = new URI(baseUrl);

        ResponseEntity<Employee> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.POST,
                requestEntity,
                Employee.class
        );

        return responseEntity.getBody();
    }*/


}
