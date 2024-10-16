package ru.aston.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.controller.dto.HeroDto;
import ru.aston.course.controller.dto.HeroWithFractionDto;
import ru.aston.course.controller.mapper.HeroMapper;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Hero;
import ru.aston.course.model.Role;
import ru.aston.course.repository.HeroRepository;
import ru.aston.course.repository.RoleRepository;

import java.util.*;

@Service
@Transactional
public class HeroService {
    HeroRepository heroRepository;


    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;

    }

    @Transactional(readOnly = true)
    public List<HeroDto> findAll() {
        List<Hero> heroes = heroRepository.findAll();
        List<HeroDto> heroDtos = new ArrayList<>();//
        for (Hero hero : heroes) {
            heroDtos.add(HeroMapper.INSTANCE.toDto(hero));
        }
        return heroDtos;
    }

    @Transactional(readOnly = true)
    public List<HeroWithFractionDto> findAllWithFraction() {
        List<Hero> heroes = heroRepository.findAll();
        List<HeroWithFractionDto> heroDtos = new ArrayList<>();
        for (Hero hero : heroes) {
            heroDtos.add(HeroMapper.INSTANCE.toDtoWithFraction(hero));
        }
        return heroDtos;
    }
}
