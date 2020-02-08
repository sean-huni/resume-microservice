package xyz.seanhuni.resume.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestAnsDto {
    private Integer id;
    private String quest;
    private String ans;
    private List<QuestionInfoDto> questionInfoList;
}
