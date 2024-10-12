package ru.aston.course.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.aston.course.controller.dto.FractionDto;
import ru.aston.course.model.Fraction;
import ru.aston.course.service.FractionService;

import java.util.List;


@RestController
@RequestMapping("/fraction")
public class FractionController {
    FractionService fractionService;

    @Autowired
    public FractionController(FractionService fractionService) {
        this.fractionService = fractionService;
    }


    @GetMapping("/all")
    public List<FractionDto> findAll() {
        return fractionService.findAll();
    }
    @GetMapping("/{id}")
    public FractionDto findById(@PathVariable("id") Long id) {
        return fractionService.findById(id);
    }
    @PostMapping("/new")
    public ResponseEntity<FractionDto> create(HttpServletRequest request) {
        String name = request.getParameter("name");
        FractionDto fractionDto = new FractionDto(null,name);
        return new ResponseEntity<>(fractionService.save(fractionDto), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FractionDto> update(@PathVariable("id") Long id, HttpServletRequest request) {
        String name = request.getParameter("name");
        FractionDto fractionDto = new FractionDto(id,name);
        return new ResponseEntity<>(fractionService.save(fractionDto), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        fractionService.delete(id);
    }
}
