package ru.aston.course.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.controller.dto.FractionDto;
import ru.aston.course.controller.mapper.FractionMapper;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Hero;
import ru.aston.course.repository.FractionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FractionServiceTest {
    @Mock
    private FractionRepository fractionRepository;
    @Mock
    private FractionMapper fractionMapper;
    @InjectMocks
    private FractionService fractionService;
    private Fraction fraction;
    private FractionDto fractionDto;

    @BeforeEach
    public void setUp() {
        fraction = new Fraction(1L, "fractionName");
        fractionDto = new FractionDto(1L, "fractionName");
    }

    @Test
    @Transactional(readOnly = true)
    void findAll() {
        when(fractionRepository.findAll()).thenReturn(Arrays.asList(fraction));
        fractionService = new FractionService(fractionRepository);
        fractionService.findAll();
        assertEquals(1, fractionService.findAll().size());
    }

    @Test
    void findById() {
        when(fractionRepository.findById(1L)).thenReturn(java.util.Optional.of(fraction));
        fractionService = new FractionService(fractionRepository);
        fractionService.findById(1L);
        assertEquals(Optional.of(fraction).get().getFractionName(), fractionService.findById(1L).getFractionName());
    }

    @Test
    void save() {
        when(fractionRepository.save(fraction)).thenReturn(fraction);
        fractionService = new FractionService(fractionRepository);
        fractionService.save(fractionDto);
        assertEquals(fraction.getFractionName(), fractionService.save(fractionDto).getFractionName());
    }


    @Test
    void delete() {
        when(fractionRepository.findById(1L)).thenReturn(java.util.Optional.of(fraction));
        fractionService = new FractionService(fractionRepository);
        fractionService.delete(1L);
        assertEquals(Optional.of(fraction)
                , fractionRepository.findById(1L));
    }

    @Test
    void findHeroByFractionId() {
        when(fractionRepository.findAllHeroesByFractionId(1L)).thenReturn(Arrays.asList(fraction));
        fractionService = new FractionService(fractionRepository);
        Hero hero = new Hero(1L, "heroName","heroLastName");
        List<Hero> heroes = Arrays.asList(hero);
        fraction.setHeroes(heroes);
        fractionService.findHeroByFractionId(1L);
       assertEquals(1, fractionRepository.findAllHeroesByFractionId(1L).get(0).getFractionId());
    }

    @Test
    void findHeroById() {
        when(fractionRepository.findAllHeroesByFractionId(1L)).thenReturn(Arrays.asList(fraction));
        assertEquals(1, fractionRepository.findAllHeroesByFractionId(1L).get(0).getFractionId());
    }

    @Test
    void findHeroesByFractionId() {
        when(fractionRepository.findAllHeroesByFractionId(1L)).thenReturn(Arrays.asList(fraction));
        assertEquals(1, fractionRepository.findAllHeroesByFractionId(1L).get(0).getFractionId());
    }

}