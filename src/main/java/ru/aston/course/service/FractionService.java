package ru.aston.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.controller.dto.FractionDto;
import ru.aston.course.controller.dto.FractionWithHeroDto;
import ru.aston.course.controller.mapper.FractionMapper;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Hero;
import ru.aston.course.repository.FractionRepository;

import java.util.*;

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
    public void delete(Long id) {
        fractionRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<FractionWithHeroDto> findHeroByFractionId(Long id) {
        List<Fraction> fractions = fractionRepository.findAllHeroesByFractionId(id);
        List<FractionWithHeroDto> fractionWithHeroDtos = new ArrayList<>();
        Set<Hero> heroes = new HashSet<>();
        for (int i = 0; i < fractions.size(); i++) {
            for (int j = 0; j < fractions.get(i).getHeroes().size(); j++) {
                heroes.add(fractions.get(i).getHeroes().get(j));
            }
            List<Hero> heroesList = new ArrayList<>(heroes);
            fractions.get(i).setHeroes(heroesList);
        }
        for (Fraction fraction : fractions) {
            fractionWithHeroDtos.add(FractionMapper.INSTANCE.toDtoWithHero(fraction));
        }
        return fractionWithHeroDtos;
    }
}
