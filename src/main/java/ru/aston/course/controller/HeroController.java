package ru.aston.course.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.course.controller.dto.FractionDto;
import ru.aston.course.controller.dto.HeroDto;
import ru.aston.course.controller.dto.HeroWithFractionDto;
import ru.aston.course.controller.dto.HeroWithRoleDto;
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

    @GetMapping("/role")
    public List<HeroWithRoleDto> findHeroWithRole() {
        return heroService.findAllWithRole();
    }

    @GetMapping("/{id}")
    public HeroDto findById(@PathVariable Long id) {
        return heroService.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<HeroDto> create(HttpServletRequest request) {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        Long roleId = Long.parseLong(request.getParameter("roleId"));
        Long fractionId = Long.parseLong(request.getParameter("fractionId"));
        HeroDto heroDto = new HeroDto(null, name, lastName);
        return new ResponseEntity<>(heroService.create(heroDto, roleId, fractionId), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HeroDto> update(@PathVariable("id") Long id, HttpServletRequest request) {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        Long roleId = Long.parseLong(request.getParameter("roleId"));
        Long fractionId = Long.parseLong(request.getParameter("fractionId"));
        HeroDto heroDto = new HeroDto(id, name, lastName);
        return new ResponseEntity<>(heroService.create(heroDto, roleId, fractionId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HeroDto> delete(@PathVariable("id") Long id) {
        heroService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
