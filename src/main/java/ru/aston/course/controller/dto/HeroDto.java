package ru.aston.course.controller.dto;

import ru.aston.course.model.Role;


public class HeroDto {
    private Long heroId;

    private String heroName;

    private String heroLastName;

    private Role role;

    public HeroDto(Long heroId, String heroName, String heroLastName, Role role) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroLastName = heroLastName;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
