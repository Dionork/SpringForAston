package ru.aston.course.controller.dto;

import ru.aston.course.model.Hero;

import java.util.List;

public class RoleWithHeroDto {
    private Long roleId;
    private String roleName;
    private List<Hero> hero;

    public RoleWithHeroDto(Long roleId, String roleName, List<Hero> hero) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.hero = hero;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Hero> getHeroes() {
        return hero;
    }

    public void setHeroes(List<Hero> hero) {
        this.hero = hero;
    }
}
