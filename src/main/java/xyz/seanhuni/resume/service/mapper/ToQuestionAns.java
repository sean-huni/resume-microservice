package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.QuestAnsDto;
import xyz.seanhuni.resume.dto.QuestionInfoDto;
import xyz.seanhuni.resume.persistence.entity.QuestionAns;
import xyz.seanhuni.resume.persistence.entity.QuestionInfo;

import java.util.stream.Collectors;

@Component
public class ToQuestionAns implements Converter<QuestAnsDto, QuestionAns> {
    private Converter<QuestionInfoDto, QuestionInfo> questionInfoConverter;

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public QuestionAns convert(QuestAnsDto source) {
        QuestionAns questionAns = new QuestionAns();
        questionAns.setQuest(source.getQuest());
        questionAns.setAns(source.getAns());
        questionAns.setQuestionInfoList(source.getQuestionInfoList().stream().map(questionInfoDto -> questionInfoConverter.convert(questionInfoDto)).collect(Collectors.toList()));
        questionAns.setId(source.getId());
        return questionAns;

    }
}
