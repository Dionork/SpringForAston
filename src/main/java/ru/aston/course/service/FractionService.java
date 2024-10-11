package ru.aston.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.model.Fraction;
import ru.aston.course.repository.FractionRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FractionService {
    FractionRepository fractionRepository;

    @Autowired
    public FractionService(FractionRepository fractionRepository) {
        this.fractionRepository = fractionRepository;
    }

    public List<Fraction> findAll() {


        return fractionRepository.findAll();
    }
}
