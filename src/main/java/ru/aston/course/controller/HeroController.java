package ru.aston.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.course.controller.dto.HeroDto;
import ru.aston.course.controller.dto.HeroWithFractionDto;
import ru.aston.course.model.Hero;
import ru.aston.course.service.HeroService;
import ru.aston.course.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {
    HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }
    @GetMapping("/all")
    public List<HeroDto> findAll() {
        return heroService.findAll();
    }

    @GetMapping("/fraction")
    public List<HeroWithFractionDto> findHeroWithFraction() {
        return heroService.findAllWithFraction();
    }
}
