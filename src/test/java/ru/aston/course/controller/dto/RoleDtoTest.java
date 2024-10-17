package ru.aston.course.controller.dto;

import org.junit.jupiter.api.Test;
import ru.aston.course.controller.mapper.RoleMapper;
import ru.aston.course.model.Role;

import static org.junit.jupiter.api.Assertions.*;

class RoleDtoTest {
    Role role;
    RoleDto roleDto;
    public RoleDtoTest() {
        role = new Role(1L, "ROLE_ADMIN");
        roleDto = RoleMapper.INSTANCE.toDto(role);
    }
    @Test
    void getRoleId() {
        assertEquals(role.getRoleId(), roleDto.getRoleId());
    }

    @Test
    void setRoleId() {
        roleDto.setRoleId(2L);
        assertEquals(2L, roleDto.getRoleId());
    }

    @Test
    void getRoleName() {
        assertEquals(role.getRoleName(), roleDto.getRoleName());
    }

    @Test
    void setRoleName() {
        roleDto.setRoleName("ROLE_USER");
        assertEquals("ROLE_USER", roleDto.getRoleName());
    }
    @Test
    void toModel() {
       RoleDto roleDtos = RoleMapper.INSTANCE.toDto(role);
       assertEquals(role, RoleMapper.INSTANCE.toModel(roleDtos));
    }
}