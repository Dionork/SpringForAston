package ru.aston.course.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Hero hero;

    public HeroTest() {
        hero = new Hero(1L, "Hero","HeroLastName");
    }

    @Test
    void getHeroId() {
        assertEquals(1L, hero.getHeroId());
    }

    @Test
    void setHeroId() {
        hero.setHeroId(2L);
        assertEquals(2L, hero.getHeroId());
    }

    @Test
    void getHeroName() {
        assertEquals("Hero", hero.getHeroName());
    }

    @Test
    void setHeroName() {
        hero.setHeroName("Hero2");
        assertEquals("Hero2", hero.getHeroName());
    }

    @Test
    void getHeroLastName() {
        assertEquals("HeroLastName", hero.getHeroLastName());
    }

    @Test
    void setHeroLastName() {
        hero.setHeroLastName("HeroLastName2");
        assertEquals("HeroLastName2", hero.getHeroLastName());
    }

    @Test
    void getRole() {
        hero.setRole(new Role(1L, "Role"));
        assertEquals("Role", hero.getRole().getRoleName());

    }

    @Test
    void setRole() {
        hero.setRole(new Role(1L, "Role2"));
        assertEquals("Role2", hero.getRole().getRoleName());
    }

    @Test
    void getFractions() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1L, "Fraction"));
        hero.setFractions(fractions);
        assertEquals("Fraction", hero.getFractions().get(0).getFractionName());
    }

    @Test
    void setFractions() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1L, "Fraction"));
        hero.setFractions(fractions);
        assertEquals("Fraction", hero.getFractions().get(0).getFractionName());
    }

    @Test
    void testEquals() {
        Hero hero2 = new Hero(1L, "Hero","HeroLastName");
        assertEquals(hero, hero2);
    }

    @Test
    void testHashCode() {
        Hero hero2 = new Hero(1L, "Hero","HeroLastName");
        assertEquals(hero.hashCode(), hero2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Hero{heroId=1, heroName='Hero', heroLastName='HeroLastName', role=null, fractions=null}", hero.toString());
    }
}