package xyz.seanhuni.resume.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.seanhuni.resume.dto.RecommendDto;
import xyz.seanhuni.resume.service.RecommendService;

import java.util.List;

import static xyz.seanhuni.resume.commons.Constants.REST_V1_ENDPOINT;

@RestController
@RequestMapping(REST_V1_ENDPOINT + "recommend")
public class RecommendRest {
    private RecommendService recommendService;

    public RecommendRest(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @GetMapping
    public List<RecommendDto> findAllRecommendations() {
        return recommendService.findAll();
    }
}
