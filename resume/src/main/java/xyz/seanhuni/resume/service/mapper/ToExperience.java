package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.ExperienceDto;
import xyz.seanhuni.resume.persistence.entity.Experience;

import java.util.Objects;

@Component
public class ToExperience implements Converter<ExperienceDto, Experience> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Experience convert(ExperienceDto source) {
        if (Objects.isNull(source)) {
            return null;
        }
        Experience experience = new Experience();
        experience.setDtStart(source.getDtStart());
        experience.setDtEnd(source.getDtEnd());
        experience.setDesig(source.getDesig());
        experience.setNatow(source.getNatow());
        experience.setCurrP(source.getCurrP());
        experience.setResponsibilities(source.getResponsibilities());
        experience.setId(source.getId());
        experience.setVersion(source.getVersion());
        experience.setDtUpdated(source.getDtUpdated());
        experience.setDtCreated(source.getDtCreated());
        return experience;
    }
}
