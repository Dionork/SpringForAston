package ru.aston.course.controller.dto;

import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import ru.aston.course.controller.mapper.RoleMapper;
import ru.aston.course.model.Hero;
import ru.aston.course.model.Role;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleWithHeroDtoTest {
    Role role;
    Hero hero;
    RoleWithHeroDto dto;
    public RoleWithHeroDtoTest() {
        role = new Role(1L, "Role");
        dto = RoleMapper.INSTANCE.toDtoWithHero(role);
        hero = new Hero(1L, "Hero","heroLastName");
    }
    @Test
    void getRoleId() {
        assertEquals(role.getRoleId(), dto.getRoleId());
    }

    @Test
    void setRoleId() {
        dto.setRoleId(2L);
        assertEquals(2L, dto.getRoleId());
    }

    @Test
    void getRoleName() {
        assertEquals(role.getRoleName(), dto.getRoleName());
    }

    @Test
    void setRoleName() {
        dto.setRoleName("NewRole");
        assertEquals("NewRole", dto.getRoleName());
    }

    @Test
    void getHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        dto.setHeroes(heroes);
        assertEquals(heroes, dto.getHeroes());
    }

    @Test
    void setHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        dto.setHeroes(heroes);
        assertEquals(heroes, dto.getHeroes());
    }
}