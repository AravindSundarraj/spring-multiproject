package com.group.apartment.apartment.service;

//import com.group.apartment.apartment.domain.ApartmentDomain;
//import com.group.apartment.apartment.repo.ApartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApartmentService {

 /*   @Autowired
    ApartmentRepo apartmentRepo;
 */   /*public void addApartmentService(ApartmentDomain aptDomain){
        RestTemplate r = new RestTemplate();
        r.exchange()
                r.getForEntity()
        apartmentRepo.addApartment();
    }

    private PostDto convertToDto(ApartmentDomain aptDomain) {
        PostDto postDto = modelMapper.map(post, PostDto.class);
        postDto.setSubmissionDate(post.getSubmissionDate(),
                userService.getCurrentUser().getPreference().getTimezone());
        return postDto;
    }*/
}
