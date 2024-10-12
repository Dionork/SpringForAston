package ru.aston.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.course.model.Role;

import java.util.List;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{
    List<Role> findAll();
    List<Role> findAllHeroByRoleId(Long heroId);
}
