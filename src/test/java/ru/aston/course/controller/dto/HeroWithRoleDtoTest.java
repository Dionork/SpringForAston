package ru.aston.course.controller.dto;

import org.junit.jupiter.api.Test;
import ru.aston.course.controller.mapper.HeroMapper;
import ru.aston.course.model.Hero;
import ru.aston.course.model.Role;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroWithRoleDtoTest {
    Hero hero;
    Role role;
    HeroWithRoleDto dto;
    public HeroWithRoleDtoTest() {
        hero = new Hero(1L, "Ivan", "Ivanov");
        role = new Role(1L, "admin");
        dto = HeroMapper.INSTANCE.toDtoWithRole(hero);
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
        assertEquals("Ivan", dto.getHeroName());
    }

    @Test
    void setHeroName() {
        dto.setHeroName("Petr");
        assertEquals("Petr", dto.getHeroName());
    }

    @Test
    void getHeroLastName() {
        assertEquals("Ivanov", dto.getHeroLastName());
    }

    @Test
    void setHeroLastName() {
        dto.setHeroLastName("Petrov");
        assertEquals("Petrov", dto.getHeroLastName());
    }

    @Test
    void getRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        dto.setRoles(roles);
        assertEquals(roles, dto.getRoles());
    }

    @Test
    void setRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        dto.setRoles(roles);
        assertEquals(roles, dto.getRoles());
    }
}