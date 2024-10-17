package ru.aston.course.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import ru.aston.course.controller.dto.RoleDto;
import ru.aston.course.controller.dto.RoleWithHeroDto;
import ru.aston.course.model.Hero;
import ru.aston.course.service.RoleService;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RoleControllerTest {
    @Mock
    RoleService roleService;
    @InjectMocks
    RoleController roleController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllHeroes() {
        List<RoleWithHeroDto> t = new java.util.ArrayList<>();
        List<Hero> heroes = new java.util.ArrayList<>();
        heroes.add(new Hero(Long.valueOf(1), "heroName", "heroLastName"));
        t.add(new RoleWithHeroDto(Long.valueOf(1), "roleName", heroes));
        when(roleService.findAllWithHero(anyLong())).thenReturn(t);

        List<RoleWithHeroDto> result = roleController.findAllHeroes(Long.valueOf(1));
        List<RoleWithHeroDto> expected = new java.util.ArrayList<>();
        List<Hero> heroes1 = new java.util.ArrayList<>();
        heroes1.add(new Hero(Long.valueOf(1), "heroName", "heroLastName"));
        expected.add(new RoleWithHeroDto(Long.valueOf(1), "roleName", heroes1));
        Assertions.assertEquals(expected.get(0).getRoleId(), result.get(0).getRoleId());
    }

    @Test
    void testFindAllRoles() {
        List<RoleDto> t = new java.util.ArrayList<>();
        t.add(new RoleDto(Long.valueOf(1), "roleName"));
        when(roleService.findAll()).thenReturn(t);

        List<RoleDto> result = roleController.findAllRoles();
        List<RoleDto> expected = new java.util.ArrayList<>();
        expected.add(new RoleDto(Long.valueOf(1), "roleName"));
        Assertions.assertEquals(expected.get(0).getRoleId(), result.get(0).getRoleId());
    }

    @Test
    void testFindById() {
        when(roleService.findById(anyLong())).thenReturn(new RoleDto(Long.valueOf(1), "roleName"));

        RoleDto result = roleController.findById(Long.valueOf(1));
        Assertions.assertEquals("roleName", result.getRoleName());
    }

    @Test
    void testCreate() {
        when(roleService.save(any())).thenReturn(new RoleDto(null, "roleName"));
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("roleName");
        ResponseEntity<RoleDto> result = roleController.create(request);
        Assertions.assertEquals("roleName", result.getBody().getRoleName());
    }

    @Test
    void testUpdate() {
        when(roleService.update(anyLong(), anyString())).thenReturn(new RoleDto(Long.valueOf(1), "roleName"));
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("roleName");
        ResponseEntity<RoleDto> result = roleController.update(Long.valueOf(1), request);
        Assertions.assertEquals("roleName", result.getBody().getRoleName());
    }

    @Test
    void testDelete() {
        roleController.delete(Long.valueOf(1));
        verify(roleService).delete(anyLong());
//        ResponseEntity<Void> result = roleController.delete(Long.valueOf(1));
//        verify(roleService).delete(anyLong());
//        Assertions.assertEquals(new ResponseEntity<Void>(null, null, 0), result);
    }
}
