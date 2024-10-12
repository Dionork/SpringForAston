package ru.aston.course.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.controller.dto.FractionDto;
import ru.aston.course.controller.mapper.FractionMapper;
import ru.aston.course.model.Fraction;
import ru.aston.course.repository.FractionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FractionService {
    FractionRepository fractionRepository;


    @Autowired
    public FractionService(FractionRepository fractionRepository) {
        this.fractionRepository = fractionRepository;

    }

    @Transactional(readOnly = true)
    public List<FractionDto> findAll() {
        List<Fraction> fractions = fractionRepository.findAll();
        List<FractionDto> fractionDtos = new ArrayList<>();
        for (Fraction fraction : fractions) {
            fractionDtos.add(FractionMapper.INSTANCE.toDto(fraction));
        }
        return fractionDtos;
    }

    @Transactional(readOnly = true)
    public FractionDto findById(Long id) {
        Optional<Fraction> fraction = fractionRepository.findById(id);
        return FractionMapper.INSTANCE.toDto(fraction.orElse(null));
    }
    public FractionDto save(FractionDto fractionDto) {
       return FractionMapper.INSTANCE.toDto(fractionRepository
               .save(FractionMapper.INSTANCE.toModel(fractionDto)));
    }
    @Transactional
    public FractionDto update(Long id, String name) {
        Fraction fraction = fractionRepository.findById(id).orElse(null);
        fraction.setFractionName(name);
        return FractionMapper.INSTANCE.toDto(fractionRepository.save(fraction));
    }
    @Transactional
    public void delete(Long id) {
        fractionRepository.deleteById(id);
    }
}
