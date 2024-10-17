package ru.aston.course.controller.dto;


public class HeroDto {
    private Long heroId;

    private String heroName;

    private String heroLastName;


    public HeroDto(Long heroId, String heroName, String heroLastName) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroLastName = heroLastName;

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

}
