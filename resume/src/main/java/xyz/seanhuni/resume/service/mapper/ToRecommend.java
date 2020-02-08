package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.RecommendDto;
import xyz.seanhuni.resume.persistence.entity.Recommend;

import java.util.Objects;

@Component
public class ToRecommend implements Converter<RecommendDto, Recommend> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Recommend convert(RecommendDto source) {
        if (Objects.isNull(source)) {
            return null;
        }
        Recommend recommend = new Recommend();
        recommend.setName(source.getName());
        recommend.setDesign(source.getDesign());
        recommend.setNote(source.getNote());
        recommend.setId(source.getId());
        return recommend;

    }
}
