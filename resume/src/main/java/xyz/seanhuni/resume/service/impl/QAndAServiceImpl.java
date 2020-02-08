package xyz.seanhuni.resume.service.impl;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import xyz.seanhuni.resume.dto.QuestAnsDto;
import xyz.seanhuni.resume.persistence.entity.QuestionAns;
import xyz.seanhuni.resume.persistence.repo.QAndARepo;
import xyz.seanhuni.resume.service.QAndAService;

import java.util.List;

@Service
public class QAndAServiceImpl implements QAndAService {
    private QAndARepo qAndARepo;
    private Converter<QuestAnsDto, QuestionAns> questAnsConverter;
    private Converter<QuestionAns, QuestAnsDto> questAnsDtoConverter;

    public QAndAServiceImpl(QAndARepo qAndARepo, Converter<QuestAnsDto, QuestionAns> questAnsConverter, Converter<QuestionAns, QuestAnsDto> questAnsDtoConverter) {
        this.qAndARepo = qAndARepo;
        this.questAnsConverter = questAnsConverter;
        this.questAnsDtoConverter = questAnsDtoConverter;
    }

    @Override
    public List<QuestAnsDto> findAll() {
        return null;
    }

    @Override
    public QuestAnsDto findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public QuestAnsDto saveOrUpdate(QuestAnsDto domainObject) {
        return null;
    }
}