package ru.aston.course.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.course.controller.dto.RoleDto;
import ru.aston.course.controller.dto.RoleWithHeroDto;
import ru.aston.course.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    RoleService roleService;


    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/hero/{id}")
    public List<RoleWithHeroDto> findAllHeroes(@PathVariable("id") Long id) {
        return roleService.findAllWithHero(id);
    }
    @GetMapping("/all")
    public List<RoleDto> findAllRoles() {
        return roleService.findAll();
    }
    @GetMapping("/{id}")
    public RoleDto findById(@PathVariable("id") Long id) {
        return roleService.findById(id);
    }
    @PostMapping("/new")
    public ResponseEntity<RoleDto> create(HttpServletRequest request) {
        String name = request.getParameter("name");
        RoleDto roleDto = new RoleDto(null, name);
        return new ResponseEntity<>(roleService.save(roleDto), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<RoleDto> update(@PathVariable("id") Long id,HttpServletRequest request) {
        String name = request.getParameter("name");
        return new ResponseEntity<>(roleService.update(id, name), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Long id) {
        roleService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
