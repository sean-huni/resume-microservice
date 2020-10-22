package xyz.seanhuni.resume.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.seanhuni.resume.pojo.resp.EducationDto;
import xyz.seanhuni.resume.service.EducationService;

import java.util.List;

import static xyz.seanhuni.resume.commons.Constants.REST_V1_ENDPOINT;

@RestController
@RequestMapping(REST_V1_ENDPOINT + "education")
public class EducationRest {
    private EducationService educationService;

    public EducationRest(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public List<EducationDto> findAllEducationItems() {
        return educationService.findAll();
    }
}
