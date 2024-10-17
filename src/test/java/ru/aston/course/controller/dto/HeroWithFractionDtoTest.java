package ru.aston.course.controller.dto;

import org.junit.jupiter.api.Test;
import ru.aston.course.controller.mapper.HeroMapper;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroWithFractionDtoTest {
    Hero hero;
    Fraction fraction;
    HeroWithFractionDto dto;

    public HeroWithFractionDtoTest() {
        hero = new Hero(1L, "name", "heroLastName");
        fraction = new Fraction(1L, "");
        dto = HeroMapper.INSTANCE.toDtoWithFraction(hero);
    }

    @Test
    void getHeroId() {
        assertEquals(1L, dto.getHeroId());
    }

    @Test
    void setHeroId() {
        dto.setHeroId(2L);
        assertEquals(2L, dto.getHeroId());
    }

    @Test
    void getHeroName() {
        assertEquals("name", dto.getHeroName());
    }

    @Test
    void setHeroName() {
        dto.setHeroName("newName");
        assertEquals("newName", dto.getHeroName());
    }

    @Test
    void getHeroLastName() {
        assertEquals("heroLastName", dto.getHeroLastName());
    }

    @Test
    void setHeroLastName() {
        dto.setHeroLastName("newLastName");
        assertEquals("newLastName", dto.getHeroLastName());
    }

    @Test
    void getFractions() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(fraction);
        dto.setFractions(fractions);
        assertEquals(fractions, dto.getFractions());
    }

    @Test
    void setFractions() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(fraction);
        dto.setFractions(fractions);
        assertEquals(fractions, dto.getFractions());
    }
}