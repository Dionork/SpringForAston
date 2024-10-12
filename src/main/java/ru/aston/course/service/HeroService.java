package ru.aston.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.controller.dto.HeroDto;
import ru.aston.course.controller.mapper.HeroMapper;
import ru.aston.course.model.Hero;
import ru.aston.course.model.Role;
import ru.aston.course.repository.HeroRepository;
import ru.aston.course.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HeroService {
    HeroRepository heroRepository;
    RoleRepository roleRepository;
    @Autowired
    public HeroService(HeroRepository heroRepository, RoleRepository roleRepository) {
        this.heroRepository = heroRepository;
        this.roleRepository = roleRepository;
    }
    @Transactional(readOnly = true)
    public List<HeroDto> findAll(){
        List<Hero> heroes = heroRepository.findAll();
        List<HeroDto> heroDtos = new ArrayList<>();

        for (Hero hero : heroes) {
            hero.setRole(roleRepository.findById(hero.getRole().getRoleId()).orElse(null));
//          Optional<Role> role = roleRepository.findById(hero.getRole().getRoleId());
             heroDtos.add(HeroMapper.INSTANCE.toDto(hero));

        }
        return heroDtos;
    }
}
