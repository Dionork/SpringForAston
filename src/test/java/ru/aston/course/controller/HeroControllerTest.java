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
import ru.aston.course.controller.dto.HeroDto;
import ru.aston.course.controller.dto.HeroWithFractionDto;
import ru.aston.course.controller.dto.HeroWithRoleDto;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Role;
import ru.aston.course.service.HeroService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class HeroControllerTest {
    @Mock
    HeroService heroService;
    @InjectMocks
    HeroController heroController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<HeroDto> t = new ArrayList<>();
        t.add(new HeroDto(Long.valueOf(1), "heroName", "heroLastName"));
        when(heroService.findAll()).thenReturn(t);

        List<HeroDto> result = heroController.findAll();
        List<HeroDto> expected = new ArrayList<>();
        expected.add(new HeroDto(Long.valueOf(1), "heroName", "heroLastName"));
        Assertions.assertEquals(expected.get(0).getHeroId(), result.get(0).getHeroId());
    }

    @Test
    void testFindHeroWithFraction() {
        List<HeroWithFractionDto> t = new ArrayList<>();
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(Long.valueOf(1), "fractionName"));
        t.add(new HeroWithFractionDto(Long.valueOf(1), "heroName", "heroLastName", fractions));
        when(heroService.findAllWithFraction()).thenReturn(t);

        List<HeroWithFractionDto> result = heroController.findHeroWithFraction();
        List<Fraction> fractions1 = new ArrayList<>();
        fractions1.add(new Fraction(Long.valueOf(1), "fractionName"));
        List<HeroWithFractionDto> expected = new ArrayList<>();
        expected.add(new HeroWithFractionDto(Long.valueOf(1), "heroName", "heroLastName", fractions1));
        Assertions.assertEquals(expected.get(0).getHeroId(), result.get(0).getHeroId());
    }

    @Test
    void testFindHeroWithRole() {
        List<Role> roles1 = new ArrayList<>();
        roles1.add(new Role(Long.valueOf(1), "roleName"));
        List<HeroWithRoleDto> t = new ArrayList<>();
        t.add(new HeroWithRoleDto(Long.valueOf(1), "heroName", "heroLastName", roles1));
        when(heroService.findAllWithRole()).thenReturn(t);

        List<HeroWithRoleDto> result = heroController.findHeroWithRole();
        List<HeroWithRoleDto> expected = new ArrayList<>();
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(Long.valueOf(1), "roleName"));
        expected.add(new HeroWithRoleDto(Long.valueOf(1), "heroName", "heroLastName", roles));
        Assertions.assertEquals(expected.get(0).getHeroId(), result.get(0).getHeroId());
    }

    @Test
    void testFindById() {
        when(heroService.findById(anyLong())).thenReturn(new HeroDto(Long.valueOf(1), "heroName", "heroLastName"));
        HeroDto result = heroController.findById(Long.valueOf(1));
        Assertions.assertEquals("heroName", result.getHeroName());
    }

    @Test
    void testCreate() {
        when(heroService.create(any(), anyLong(), anyLong())).thenReturn(new HeroDto(null, "heroName", "heroLastName"));
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        when(request.getParameter("heroName")).thenReturn("heroName");
        when(request.getParameter("heroLastName")).thenReturn("heroLastName");
        when(request.getParameter("roleId")).thenReturn("1");
        when(request.getParameter("fractionId")).thenReturn("1");
        ResponseEntity<HeroDto> result = heroController.create(request);
        Assertions.assertEquals( "heroName",result.getBody().getHeroName());
    }

    @Test
    void testUpdate() {
        when(heroService.create(any(), anyLong(), anyLong())).thenReturn(new HeroDto(Long.valueOf(1), "heroName", "heroLastName"));
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        when(request.getParameter("heroName")).thenReturn("heroName");
        when(request.getParameter("heroLastName")).thenReturn("heroLastName");
        when(request.getParameter("roleId")).thenReturn("1");
        when(request.getParameter("fractionId")).thenReturn("1");
        ResponseEntity<HeroDto> result = heroController.update(Long.valueOf(1), request);
        Assertions.assertEquals( result.getBody().getHeroId(), Long.valueOf(1));
    }

    @Test
    void testDelete() {
        heroController.delete(Long.valueOf(1));
        verify(heroService).delete(anyLong());
    }
}
