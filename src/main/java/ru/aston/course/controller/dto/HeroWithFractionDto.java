package ru.aston.course.controller.dto;

import ru.aston.course.model.Fraction;

import java.util.List;

public class HeroWithFractionDto {
    private Long heroId;

    private String heroName;

    private String heroLastName;
    private List<Fraction> fractions;

    public HeroWithFractionDto(Long heroId, String heroName, String heroLastName, List<Fraction> fractions) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroLastName = heroLastName;
        this.fractions = fractions;
    }

    public Long getHeroId() {
        return heroId;
    }

    public void setHeroId(Long heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroLastName() {
        return heroLastName;
    }

    public void setHeroLastName(String heroLastName) {
        this.heroLastName = heroLastName;
    }

    public List<Fraction> getFractions() {
        return fractions;
    }

    public void setFractions(List<Fraction> fractions) {
        this.fractions = fractions;
    }
}
