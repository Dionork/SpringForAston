package ru.aston.course.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroServiceTest {
    @Mock
    private HeroRepository heroRepository;
    @Mock
    private FractionRepository fractionRepository;
    @Mock
    private RoleRepository roleRepository;
    @InjectMocks
    private HeroService heroService;
    private Hero hero;
    private HeroMapper heroMapper;
    private HeroDto heroDto;
    private HeroWithFractionDto heroWithFractionDto;
    private HeroWithRoleDto heroWithRoleDto;
    @BeforeEach
    void setUp() {
        List<Fraction> fractions = Arrays.asList(new Fraction(1L, "name"));
        List<Role> roles = Arrays.asList(new Role(1L, "name"));
        hero = new Hero(1L, "name", "surname");
        heroDto = new HeroDto(1L, "name", "surname");
        heroWithFractionDto = new HeroWithFractionDto(1L, "name", "surname",fractions);
        heroWithRoleDto = new HeroWithRoleDto(1L, "name", "surname",roles);
    }
    @Test
    void findAll() {
        when(heroRepository.findAll()).thenReturn(Arrays.asList(hero));
        heroService = new HeroService(heroRepository, fractionRepository, roleRepository);
        heroService.findAll();
        assertEquals(1, heroService.findAll().size());
    }

    @Test
    void findAllWithFraction() {
        hero.setFractions(Arrays.asList(new Fraction(1L, "name")));
        when(heroRepository.findAll()).thenReturn(Arrays.asList(hero));
        heroService = new HeroService(heroRepository, fractionRepository, roleRepository);
        heroService.findAllWithFraction();
        assertEquals(1, heroService.findAllWithFraction().get(0).getFractions().get(0).getFractionId());
    }

    @Test
    void findAllWithRole() {
        hero.setRole(new Role(1L, "name"));
        when(heroRepository.findAll()).thenReturn(Arrays.asList(hero));
        heroService = new HeroService(heroRepository, fractionRepository, roleRepository);
        heroService.findAllWithRole();
        assertEquals(1, heroService.findAllWithRole().get(0).getRoles().get(0).getRoleId());
    }

    @Test
    void findById() {
        when(heroRepository.findById(1L)).thenReturn(Optional.of(hero));
        heroService = new HeroService(heroRepository, fractionRepository, roleRepository);
        heroService.findById(1L);
        assertEquals(1, heroService.findById(1L).getHeroId());
    }

    @Test
    void create() {
        hero.setRole(new Role(1L, "name"));
        when(roleRepository.findById(1L)).thenReturn(Optional.of(new Role(1L, "name")));
        when(fractionRepository.findById(1L)).thenReturn(Optional.of(new Fraction(1L, "name")));
        when(heroRepository.save(hero)).thenReturn(hero);
        heroService = new HeroService(heroRepository, fractionRepository, roleRepository);
        heroService.create(heroDto,1L,1L);
        assertEquals(1, heroService.create(heroDto,1L,1L).getHeroId());
    }

    @Test
    void delete() {
        when(heroRepository.findById(1L)).thenReturn(Optional.of(hero));
        heroService = new HeroService(heroRepository, fractionRepository, roleRepository);
        heroService.delete(1L);
       assertEquals(Optional.of(hero), heroRepository.findById(1L));
    }
}