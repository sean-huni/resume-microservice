package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.ExperienceDto;
import xyz.seanhuni.resume.persistence.entity.Experience;

import java.util.Objects;

@Component
public class ToExperienceDto implements Converter<Experience, ExperienceDto> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public ExperienceDto convert(Experience source) {
        if (Objects.isNull(source)) {
            return null;
        }
        ExperienceDto experienceDto = new ExperienceDto();
        experienceDto.setId(source.getId());
        experienceDto.setDtStart(source.getDtStart());
        experienceDto.setDtEnd(source.getDtEnd());
        experienceDto.setDesig(source.getDesig());
        experienceDto.setNatow(source.getNatow());
        experienceDto.setCurrP(source.getCurrP());
        experienceDto.setVersion(source.getVersion());
        experienceDto.setDtUpdated(source.getDtUpdated());
        experienceDto.setDtCreated(source.getDtCreated());
        experienceDto.setResponsibilities(source.getResponsibilities());
        return experienceDto;

    }
}
