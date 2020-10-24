package xyz.seanhuni.resume.service.impl;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import xyz.seanhuni.resume.persistence.entity.Experience;
import xyz.seanhuni.resume.persistence.repo.ExperienceRepo;
import xyz.seanhuni.resume.pojo.resp.ExperienceDto;
import xyz.seanhuni.resume.service.ExperienceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    private ExperienceRepo experienceRepo;
    private Converter<Experience, ExperienceDto> experienceDtoConverter;
    private Converter<ExperienceDto, Experience> experienceConverter;

    public ExperienceServiceImpl(ExperienceRepo experienceRepo, Converter<Experience, ExperienceDto> experienceDtoConverter, Converter<ExperienceDto, Experience> experienceConverter) {
        this.experienceRepo = experienceRepo;
        this.experienceDtoConverter = experienceDtoConverter;
        this.experienceConverter = experienceConverter;
    }

    @Override
    public List<ExperienceDto> findAll() {
        return experienceRepo.findAll().parallelStream().map(education -> experienceDtoConverter.convert(education)).collect(Collectors.toList());
    }

    @Override
    public ExperienceDto findById(Integer id) {
        return experienceDtoConverter.convert(experienceRepo.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Integer id) {
        experienceRepo.deleteById(id);
    }

    @Override
    public ExperienceDto saveOrUpdate(ExperienceDto domainObject) {
        return experienceDtoConverter.convert(experienceRepo.save(experienceConverter.convert(domainObject)));
    }
}
