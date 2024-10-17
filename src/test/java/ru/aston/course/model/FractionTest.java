package ru.aston.course.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private final Fraction fraction;

    FractionTest(){
        fraction = new Fraction(1L, "Fraction 1");
    }

    @Test
    void getFractionId() {
        assertEquals(1L, fraction.getFractionId());
    }

    @Test
    void setFractionId() {
    fraction.setFractionId(2L);
    assertEquals(2L, fraction.getFractionId());
    }

    @Test
    void getFractionName() {
        assertEquals("Fraction 1", fraction.getFractionName());
    }

    @Test
    void setFractionName() {
        fraction.setFractionName("Fraction 2");
        assertEquals("Fraction 2", fraction.getFractionName());
    }

    @Test
    void getHeroes() {
        Hero hero = new Hero();
        hero.setHeroId(1L);
        hero.setHeroName("Hero 1");
        hero.setHeroLastName("LastName 1");
        hero.setRole(null);
        hero.setFractions(null);
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        fraction.setHeroes(heroes);
        assertEquals(heroes.size(), fraction.getHeroes().size());
    }

    @Test
    void setHeroes() {
        fraction.setHeroes(null);
        assertNull( fraction.getHeroes());
    }

    @Test
    void testEquals() {
        Fraction fraction1 = new Fraction();
        fraction1.setFractionId(1L);
        fraction1.setFractionName("Fraction 1");

        Fraction fraction2 = new Fraction();
        fraction2.setFractionId(1L);
        fraction2.setFractionName("Fraction 1");

        assertEquals(fraction1,fraction2);
    }

    @Test
    void testHashCode() {
        Fraction fraction1 = new Fraction();
        fraction1.setFractionId(1L);
        fraction1.setFractionName("Fraction 1");

        Fraction fraction2 = new Fraction();
        fraction2.setFractionId(1L);
        fraction2.setFractionName("Fraction 1");

        assertEquals(fraction1.hashCode(), fraction2.hashCode());
    }

    @Test
    void testToString() {
        Fraction fractions = new Fraction();
        fractions.setFractionId(1L);
        fractions.setFractionName("Fraction 1");

        assertEquals("Fraction{fractionId=1, fractionName='Fraction 1'}", fractions.toString());
    }
}