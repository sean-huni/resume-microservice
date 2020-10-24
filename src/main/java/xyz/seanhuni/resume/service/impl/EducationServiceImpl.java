package xyz.seanhuni.resume.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import xyz.seanhuni.resume.persistence.entity.Education;
import xyz.seanhuni.resume.persistence.repo.EducationRepo;
import xyz.seanhuni.resume.pojo.resp.EducationDto;
import xyz.seanhuni.resume.service.EducationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationServiceImpl implements EducationService {
    private EducationRepo educationRepo;
    private Converter<EducationDto, Education> toEducation;
    private Converter<Education, EducationDto> toEducationDto;

    public EducationServiceImpl(EducationRepo educationRepo, @Qualifier("toEducationDto") Converter<Education, EducationDto> toEducationDto) {
        this.educationRepo = educationRepo;
        this.toEducationDto = toEducationDto;
    }

    @Autowired
    private void setToEducation(@Qualifier("toEducation") Converter toEducation) {
        this.toEducation = toEducation;
    }

    @Override
    public List<EducationDto> findAll() {
        List<Education> educationList = educationRepo.findAll();
        return educationList.parallelStream()
                .map(education -> toEducationDto.convert(education))
                .collect(Collectors.toList());
    }

    @Override
    public EducationDto findById(Integer id) {
        return toEducationDto.convert(educationRepo.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Integer id) {
        educationRepo.deleteById(id);
    }

    @Override
    public EducationDto saveOrUpdate(EducationDto domainObject) {
        return toEducationDto.convert(educationRepo.save(toEducation.convert(domainObject)));
    }
}
