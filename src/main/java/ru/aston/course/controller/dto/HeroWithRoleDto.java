package ru.aston.course.controller.dto;


import ru.aston.course.model.Role;

import java.util.ArrayList;
import java.util.List;

public class HeroWithRoleDto {
    private Long heroId;

    private String heroName;

    private String heroLastName;
//    private Role role;
    private List<Role> roles;

    public HeroWithRoleDto(Long heroId, String heroName, String heroLastName,List<Role> roles) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroLastName = heroLastName;
        this.roles = roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
