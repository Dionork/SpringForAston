package ru.aston.course.controller.dto;

import ru.aston.course.model.Hero;

import java.util.List;

public class FractionWithHeroDto {
    private Long fractionId;

    private String fractionName;
    private List<Hero> heroes;

    public FractionWithHeroDto(Long fractionId, String fractionName, List<Hero> heroes) {
        this.fractionId = fractionId;
        this.fractionName = fractionName;
        this.heroes = heroes;
    }

    public Long getFractionId() {
        return fractionId;
    }

    public void setFractionId(Long fractionId) {
        this.fractionId = fractionId;
    }

    public String getFractionName() {
        return fractionName;
    }

    public void setFractionName(String fractionName) {
        this.fractionName = fractionName;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}
