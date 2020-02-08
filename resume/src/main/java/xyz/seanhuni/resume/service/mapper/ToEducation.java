package xyz.seanhuni.resume.service.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.dto.EducationDto;
import xyz.seanhuni.resume.persistence.entity.Education;

import java.util.Objects;

@Component("toEducation")
public class ToEducation implements Converter<EducationDto, Education> {
    @Override
    public Education convert(EducationDto source) {
        if (Objects.isNull(source)) {
            return null;
        }
        Education education = new Education();
        education.setDtStart(source.getDtStart());
        education.setDtEnd(source.getDtEnd());
        education.setInst(source.getInst());
        education.setCurrQ(source.getCurrQ());
        education.setQual(source.getQual());
        education.setHighs(source.getHighs());
        education.setOGrade(source.getOGrade());
        education.setId(source.getId());
//        education.setDtUpdated(source.getDtU);
        education.setDtCreated(source.getDtCreated());
        return education;
    }
}
