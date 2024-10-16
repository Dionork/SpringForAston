package ru.aston.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.controller.dto.HeroDto;
import ru.aston.course.controller.dto.HeroWithFractionDto;
import ru.aston.course.controller.dto.HeroWithRoleDto;
import ru.aston.course.controller.mapper.HeroMapper;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Hero;
import ru.aston.course.model.Role;
import ru.aston.course.repository.FractionRepository;
import ru.aston.course.repository.HeroRepository;
import ru.aston.course.repository.RoleRepository;

import java.util.*;

@Service
@Transactional
public class HeroService {
    HeroRepository heroRepository;
    FractionRepository fractionRepository;
    RoleRepository roleRepository;


    @Autowired
    public HeroService(HeroRepository heroRepository,FractionRepository fractionRepository, RoleRepository roleRepository) {
        this.heroRepository = heroRepository;
        this.fractionRepository = fractionRepository;
        this.roleRepository = roleRepository;
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
    @Transactional(readOnly = true)
    public List<HeroWithRoleDto> findAllWithRole() {
        List<Hero> heroes = heroRepository.findAll();
        List<HeroWithRoleDto> heroDtos = new ArrayList<>();
        for (Hero hero : heroes) {
            List<Role> roles = new ArrayList<>();
            roles.add(new Role(hero.getRole().getRoleId(),hero.getRole().getRoleName()));
            HeroWithRoleDto heroDto = HeroMapper.INSTANCE.toDtoWithRole(hero);
            heroDto.setRoles(roles);
            heroDtos.add(heroDto);
        }
        return heroDtos;
    }
    @Transactional(readOnly = true)
    public HeroDto findById(Long id) {
        Hero hero = heroRepository.findById(id).orElseThrow(() -> new RuntimeException("Hero not found"));
        return HeroMapper.INSTANCE.toDto(hero);
    }

    public HeroDto create(HeroDto heroDto, Long roleId, Long fractionId) {
        Hero hero = HeroMapper.INSTANCE.toModel(heroDto);
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        hero.setRole(role);
        Fraction fraction = fractionRepository.findById(fractionId).orElseThrow(() -> new RuntimeException("Fraction not found"));
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(fraction);
        hero.setFractions(fractions);
        heroRepository.save(hero);
        return HeroMapper.INSTANCE.toDto(hero);
    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }
}
