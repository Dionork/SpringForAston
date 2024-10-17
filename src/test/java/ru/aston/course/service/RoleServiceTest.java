package ru.aston.course.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.course.controller.dto.RoleDto;
import ru.aston.course.controller.mapper.FractionMapper;
import ru.aston.course.controller.mapper.RoleMapper;
import ru.aston.course.model.Role;
import ru.aston.course.repository.RoleRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {
    @Mock
    RoleRepository roleRepository;
    @Mock
    RoleMapper roleMapper;
    @InjectMocks
    Role role;
    RoleDto roleDto;
    RoleService roleService;

@BeforeEach
void setUp() {
    role = new Role(1L, "admin");
    roleDto = new RoleDto(1L, "admin");

}
    @Test
    void findAllWithHero() {
    when(roleRepository.findAllHeroByRoleId(1L)).thenReturn(Arrays.asList(role));
    roleService = new RoleService(roleRepository,roleMapper);
    roleService.findAllWithHero(1L);
    assertEquals(Arrays.asList(role),roleRepository.findAllHeroByRoleId(1L));
    }

    @Test
    void findAll() {
    when(roleRepository.findAll()).thenReturn(Arrays.asList(role));
    roleService = new RoleService(roleRepository,roleMapper);
    roleService.findAll();
    assertEquals(Arrays.asList(role),roleRepository.findAll());
    }

    @Test
    void findById() {
    when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
    roleService = new RoleService(roleRepository,roleMapper);
    roleService.findById(1L);
    assertEquals(Optional.of(role),roleRepository.findById(1L));
    }

    @Test
    void save() {
    when(roleRepository.save(role)).thenReturn(role);
    roleService = new RoleService(roleRepository,roleMapper);
    roleService.save(roleDto);
    assertEquals(role,roleRepository.save(role));
    }

    @Test
    void update() {
    when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
    when(roleRepository.save(role)).thenReturn(role);
    roleService = new RoleService(roleRepository,roleMapper);
    roleService.update(1L,"role");
    assertEquals(role,roleRepository.save(role));
    }

    @Test
    void delete() {
    when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
    roleService = new RoleService(roleRepository,roleMapper);
    roleService.delete(1L);
    assertEquals(Optional.of(role),roleRepository.findById(1L));
    }
}