package ru.aston.course.controller.dto;

import org.junit.jupiter.api.Test;
import ru.aston.course.controller.mapper.HeroMapper;
import ru.aston.course.model.Hero;

import static org.junit.jupiter.api.Assertions.*;

class HeroDtoTest {
    Hero hero;
    HeroDto heroDto;
public HeroDtoTest(){
    hero = new Hero(1L,"Иван","Иванов");
    heroDto = HeroMapper.INSTANCE.toDto(hero);
}
    @Test
    void getHeroId() {
    assertEquals(1L,heroDto.getHeroId());
    }

    @Test
    void setHeroId() {
    heroDto.setHeroId(2L);
    assertEquals(2L,heroDto.getHeroId());
    }

    @Test
    void getHeroName() {
    assertEquals("Иван",heroDto.getHeroName());
    }

    @Test
    void setHeroName() {
    heroDto.setHeroName("Петр");
    assertEquals("Петр",heroDto.getHeroName());
    }

    @Test
    void getHeroLastName() {
    assertEquals("Иванов",heroDto.getHeroLastName());
    }

    @Test
    void setHeroLastName() {
    heroDto.setHeroLastName("Петров");
    assertEquals("Петров",heroDto.getHeroLastName());
    }
    @Test
    void toModel() {
    HeroDto heroDto = HeroMapper.INSTANCE.toDto(hero);
    assertEquals(hero,HeroMapper.INSTANCE.toModel(heroDto));
    }
}