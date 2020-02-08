package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.QuestionInfoDto;
import xyz.seanhuni.resume.persistence.entity.QuestionInfo;

@Component
public class ToQuestInfoDto implements Converter<QuestionInfo, QuestionInfoDto> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public QuestionInfoDto convert(QuestionInfo source) {
        QuestionInfoDto questionInfoDto = new QuestionInfoDto();
        questionInfoDto.setId(source.getId());
        questionInfoDto.setQuestAnsId(source.getQuestAnsId());
        questionInfoDto.setBInfo(source.getBInfo());
        return questionInfoDto;
    }
}
