package com.group.apartment.apartment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "weather")
public class WeatherController {

    @GetMapping
    public String test(){
        return "Weather Test is Successful....";
    }
}
