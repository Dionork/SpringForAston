package ru.aston.course.controller.dto;

import org.junit.jupiter.api.Test;
import ru.aston.course.controller.mapper.FractionMapper;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FractionWithHeroDtoTest {
    Fraction fraction;
    FractionWithHeroDto fractionWithHeroDto;
    public FractionWithHeroDtoTest() {
        fraction = new Fraction(1L, "fractionName");
        fractionWithHeroDto = FractionMapper.INSTANCE.toDtoWithHero(fraction);
    }
    @Test
    void getFractionId() {
        assertEquals(1L, fractionWithHeroDto.getFractionId());
    }

    @Test
    void setFractionId() {
        fractionWithHeroDto.setFractionId(2L);
        assertEquals(2L, fractionWithHeroDto.getFractionId());
    }

    @Test
    void getFractionName() {
        assertEquals("fractionName", fractionWithHeroDto.getFractionName());
    }

    @Test
    void setFractionName() {
        fractionWithHeroDto.setFractionName("newFractionName");
        assertEquals("newFractionName", fractionWithHeroDto.getFractionName());
    }

    @Test
    void getHeroes() {
        Hero hero = new Hero(1L, "heroName", "heroSurname");
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        fractionWithHeroDto.setHeroes(heroes);
        assertEquals(heroes, fractionWithHeroDto.getHeroes());
    }

    @Test
    void setHeroes() {
        Hero hero = new Hero(1L, "heroName", "heroSurname");
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        fractionWithHeroDto.setHeroes(heroes);
        assertEquals(heroes, fractionWithHeroDto.getHeroes());
    }
}