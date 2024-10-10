package ru.aston.course.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_name_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<Hero> hero;

    public Role() {
    }

    public Role(Long roleId, String roleName) {
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

    public List<Hero> getHero() {
        return hero;
    }

    public void setHero(List<Hero> hero) {
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "Role{" +
               "roleId=" + roleId +
               ", roleName='" + roleName + '\'' +
               '}';
    }
}
