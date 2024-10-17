package ru.aston.course.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {
    Role role;
    public RoleTest (){
        role = new Role(1L, "admin");
    }
    @Test
    void getRoleId() {
        assertEquals(1L, role.getRoleId());
    }

    @Test
    void setRoleId() {
        role.setRoleId(2L);
        assertEquals(2L, role.getRoleId());
    }

    @Test
    void getRoleName() {
        assertEquals("admin", role.getRoleName());
    }

    @Test
    void setRoleName() {
        role.setRoleName("user");
        assertEquals("user", role.getRoleName());
    }

    @Test
    void getHero() {
        Hero hero = new Hero();
        hero.setHeroId(1L);
        hero.setHeroName("Hero 1");
        hero.setHeroLastName("LastName 1");
        hero.setRole(null);
        hero.setFractions(null);
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        role.setHero(heroes);
        assertEquals(heroes, role.getHero());
    }

    @Test
    void setHero() {
        Hero hero = new Hero();
        hero.setHeroId(1L);
        hero.setHeroName("Hero 1");
        hero.setHeroLastName("LastName 1");
        hero.setRole(null);
        hero.setFractions(null);
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        role.setHero(heroes);
        assertEquals(heroes, role.getHero());
    }

    @Test
    void testEquals() {
        Role role1 = new Role(1L, "admin");
        Role role2 = new Role(1L, "admin");
        assertEquals(role1, role2);
    }

    @Test
    void testHashCode() {
        Role role1 = new Role(1L, "admin");
        Role role2 = new Role(1L, "admin");
        assertEquals(role1.hashCode(), role2.hashCode());
    }

    @Test
    void testToString() {
        Role role = new Role(1L, "admin");
        assertEquals("Role{roleId=1, roleName='admin'}", role.toString());
    }
}