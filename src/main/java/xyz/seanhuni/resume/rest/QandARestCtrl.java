package xyz.seanhuni.resume.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.seanhuni.resume.dto.QuestAnsDto;
import xyz.seanhuni.resume.service.QAndAService;

import java.util.List;

import static xyz.seanhuni.resume.commons.Constants.REST_V1_ENDPOINT;

@RestController
@RequestMapping(REST_V1_ENDPOINT + "questions-and-answers")
public class QandARestCtrl {
    private QAndAService qAndAService;

    public QandARestCtrl(QAndAService qAndAService) {
        this.qAndAService = qAndAService;
    }

    @GetMapping
    public List<QuestAnsDto> findAllQuestionsAndAnswers() {
        return qAndAService.findAll();
    }
}
