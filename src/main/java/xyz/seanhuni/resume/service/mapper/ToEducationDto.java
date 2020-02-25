package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.EducationDto;
import xyz.seanhuni.resume.persistence.entity.Education;

import java.util.Objects;

@Component("toEducationDto")
public class ToEducationDto implements Converter<Education, EducationDto> {

    @Override
    public EducationDto convert(Education source) {
        if (Objects.isNull(source)) {
            return null;
        }
        EducationDto educationDto = new EducationDto();
        educationDto.setDtStart(source.getDtStart());
        educationDto.setDtEnd(source.getDtEnd());
        educationDto.setInst(source.getInst());
        educationDto.setLoca(source.getLoca());
        educationDto.setCurrQ(source.getCurrQ());
        educationDto.setQual(source.getQual());
        educationDto.setHighs(source.getHighs());
        educationDto.setOGrade(source.getOGrade());
        educationDto.setDtCreated(source.getDtCreated());
        return educationDto;
    }
}
