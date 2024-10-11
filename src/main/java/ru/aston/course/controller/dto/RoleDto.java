package ru.aston.course.controller.dto;


import ru.aston.course.model.Hero;

import java.util.List;

public class RoleDto {
    private Long roleId;
    private String roleName;
   // private List<Hero> hero;

    public RoleDto(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
