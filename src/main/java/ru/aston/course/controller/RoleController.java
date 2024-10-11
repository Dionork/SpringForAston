package ru.aston.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.course.controller.dto.RoleDto;
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

    @RequestMapping()
    public List<RoleDto> getAllRoles() {
        return roleService.findAll();
    }
}
