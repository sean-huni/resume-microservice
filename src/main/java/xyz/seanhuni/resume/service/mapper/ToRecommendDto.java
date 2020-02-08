package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.RecommendDto;
import xyz.seanhuni.resume.persistence.entity.Recommend;

import java.util.Objects;

@Component
public class ToRecommendDto implements Converter<Recommend, RecommendDto> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public RecommendDto convert(Recommend source) {
        if (Objects.isNull(source)) {
            return null;
        }
        RecommendDto recommendDto = new RecommendDto();
        recommendDto.setId(source.getId());
        recommendDto.setName(source.getName());
        recommendDto.setDesign(source.getDesign());
        recommendDto.setNote(source.getNote());
        return recommendDto;
    }
}
