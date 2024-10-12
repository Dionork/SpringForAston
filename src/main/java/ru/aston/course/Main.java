package ru.aston.course;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.course.controller.dto.RoleDto;
import ru.aston.course.controller.mapper.RoleMapper;
import ru.aston.course.model.Fraction;
import ru.aston.course.model.Hero;
import ru.aston.course.model.Role;
import ru.aston.course.repository.FractionRepository;
import ru.aston.course.service.FractionService;

public class Main {
    public static void main(String[] args) {
        RoleDto roleDto = new RoleDto(3L, "admin");
        System.out.println(RoleMapper.INSTANCE.toModel(roleDto));
    }
}
