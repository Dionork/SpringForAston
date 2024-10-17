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
import ru.aston.course.controller.dto.FractionDto;
import ru.aston.course.controller.dto.FractionWithHeroDto;
import ru.aston.course.model.Hero;
import ru.aston.course.service.FractionService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FractionControllerTest {
    @Mock
    FractionService fractionService;
    @InjectMocks
    FractionController fractionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<FractionDto> t = new java.util.ArrayList<>();
        t.add(new FractionDto(Long.valueOf(1), "fractionName"));
        when(fractionService.findAll()).thenReturn(t);

        List<FractionDto> result = fractionController.findAll();
        List<FractionDto> expected = new java.util.ArrayList<>();
        expected.add(new FractionDto(Long.valueOf(1), "fractionName"));
        Assertions.assertEquals(expected.size(), result.size());
    }

    @Test
    void testFindById() {
        when(fractionService.findById(anyLong())).thenReturn(new FractionDto(Long.valueOf(1), "fractionName"));

        FractionDto result = fractionController.findById(Long.valueOf(1));
        Assertions.assertEquals( "fractionName", result.getFractionName());
    }

    @Test
    void testCreate() {
        when(fractionService.save(any())).thenReturn(new FractionDto(null, "fractionName"));
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        when(request.getParameter("fractionName")).thenReturn("fractionName");
        ResponseEntity<FractionDto> result = fractionController.create(request);
        assertEquals(result.getBody().getFractionName(), "fractionName");
    }

    @Test
    void testUpdate() {
        when(fractionService.save(any())).thenReturn(new FractionDto(Long.valueOf(1), "fractionName"));
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("name");
        ResponseEntity<FractionDto> result = fractionController.update(Long.valueOf(1), request);
       assertEquals(result.getBody().getFractionName(), "fractionName");
    }

    @Test
    void testDelete() {
        fractionController.delete(Long.valueOf(1));
        verify(fractionService).delete(anyLong());
    }

    @Test
    void testGetFractionWithHero() {
        List<FractionWithHeroDto> t = new java.util.ArrayList<>();
        List<Hero> heroes1 = new java.util.ArrayList<>();
        heroes1.add(new Hero(Long.valueOf(1), "heroName", "heroLastName"));
        t.add(new FractionWithHeroDto(Long.valueOf(1), "fractionName", heroes1));
        when(fractionService.findHeroByFractionId(anyLong())).thenReturn(t);

        List<FractionWithHeroDto> result = fractionController.getFractionWithHero(Long.valueOf(1));
        List<Hero> heroes = new java.util.ArrayList<>();
        heroes.add(new Hero(Long.valueOf(1), "heroName", "heroLastName"));
        List<FractionWithHeroDto> expected = new java.util.ArrayList<>();
        expected.add(new FractionWithHeroDto(Long.valueOf(1), "fractionName", heroes));
        Assertions.assertEquals(expected.get(0).getFractionId(), result.get(0).getFractionId());
    }
}

