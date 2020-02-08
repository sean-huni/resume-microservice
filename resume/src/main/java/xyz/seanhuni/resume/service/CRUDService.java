package xyz.seanhuni.resume.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PROJECT   : resume
 * PACKAGE   : xyz.kudzai.resume.service
 * USER      : sean
 * DATE      : 05-August-2017
 * TIME      : 08:11
 */
@Service
public interface CRUDService<T> {
    List<T> findAll();

    T findById(Integer id);

    void deleteById(Integer id);

    T saveOrUpdate(T domainObject);
}
