package com.marianowinar.warmup.service.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Services<T> {
    String create(T entity);
    String update(T entity);
    boolean delete(Long id);
    List<T> viewAll();
    boolean existsById(Long id);
}
