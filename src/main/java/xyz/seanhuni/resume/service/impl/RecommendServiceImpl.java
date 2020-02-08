package xyz.seanhuni.resume.service.impl;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import xyz.seanhuni.resume.dto.RecommendDto;
import xyz.seanhuni.resume.persistence.entity.Recommend;
import xyz.seanhuni.resume.persistence.repo.RecommendRepo;
import xyz.seanhuni.resume.service.RecommendService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendServiceImpl implements RecommendService {
    private RecommendRepo recommendRepo;
    private Converter<Recommend, RecommendDto> recommendDtoConverter;
    private Converter<RecommendDto, Recommend> recommendConverter;

    public RecommendServiceImpl(RecommendRepo recommendRepo, Converter<Recommend, RecommendDto> recommendDtoConverter, Converter<RecommendDto, Recommend> recommendConverter) {
        this.recommendRepo = recommendRepo;
        this.recommendDtoConverter = recommendDtoConverter;
        this.recommendConverter = recommendConverter;
    }

    @Override
    public List<RecommendDto> findAll() {
        return recommendRepo.findAll().parallelStream().map(recommend -> recommendDtoConverter.convert(recommend)).collect(Collectors.toList());
    }

    @Override
    public RecommendDto findById(Integer id) {
        return recommendDtoConverter.convert(recommendRepo.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Integer id) {
        recommendRepo.deleteById(id);
    }

    @Override
    public RecommendDto saveOrUpdate(RecommendDto domainObject) {
        Recommend recommend = recommendConverter.convert(domainObject);
        return recommendDtoConverter.convert(recommendRepo.save(recommend));
    }
}
