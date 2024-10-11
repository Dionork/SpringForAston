package ru.aston.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.controller.dto.RoleDto;
import ru.aston.course.controller.mapper.RoleMapper;
import ru.aston.course.model.Role;
import ru.aston.course.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleService {
    RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public List<RoleDto> findAll() {
        List<RoleDto> roleDtoList = new ArrayList<>();
        List<Role> roleList = roleRepository.findAll();
        for (Role role : roleList) {
            roleDtoList.add(RoleMapper.INSTANCE.toDto(role));
        }


        return roleDtoList;
    }
}
