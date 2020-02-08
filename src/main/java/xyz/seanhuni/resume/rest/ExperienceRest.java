package xyz.seanhuni.resume.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.seanhuni.resume.dto.ExperienceDto;
import xyz.seanhuni.resume.service.ExperienceService;

import java.util.List;

import static xyz.seanhuni.resume.commons.Constants.REST_V1_ENDPOINT;

@RestController
@RequestMapping(REST_V1_ENDPOINT + "experience")
public class ExperienceRest {
    private ExperienceService experienceService;

    public ExperienceRest(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<ExperienceDto> findAllExperience() {
        return experienceService.findAll();
    }
}
