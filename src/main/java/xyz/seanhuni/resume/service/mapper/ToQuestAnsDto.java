package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.QuestAnsDto;
import xyz.seanhuni.resume.dto.QuestionInfoDto;
import xyz.seanhuni.resume.persistence.entity.QuestionAns;
import xyz.seanhuni.resume.persistence.entity.QuestionInfo;

import java.util.stream.Collectors;

@Component
public class ToQuestAnsDto implements Converter<QuestionAns, QuestAnsDto> {
    private Converter<QuestionInfo, QuestionInfoDto> questionInfoDtoConverter;

    public ToQuestAnsDto(Converter<QuestionInfo, QuestionInfoDto> questionInfoDtoConverter) {
        this.questionInfoDtoConverter = questionInfoDtoConverter;
    }

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public QuestAnsDto convert(QuestionAns source) {
        QuestAnsDto questAnsDto = new QuestAnsDto();
        questAnsDto.setId(source.getId());
        questAnsDto.setQuest(source.getQuest());
        questAnsDto.setAns(source.getAns());
        questAnsDto.setQuestionInfoList(source.getQuestionInfoList().stream().map(questionInfo -> questionInfoDtoConverter.convert(questionInfo)).collect(Collectors.toList()));
        return questAnsDto;

    }
}
