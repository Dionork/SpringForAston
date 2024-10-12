package ru.aston.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.course.controller.dto.RoleDto;
import ru.aston.course.controller.dto.RoleWithHeroDto;
import ru.aston.course.controller.mapper.RoleMapper;
import ru.aston.course.model.Role;
import ru.aston.course.repository.RoleRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleService {
    RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository,
                       RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Transactional(readOnly = true)
    public List<RoleWithHeroDto> findAllWithHero(Long roleId) {
        return roleRepository.findAllHeroByRoleId(roleId).stream().map(roleMapper::toDtoWithHero).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        for (Role role : roles) {
            roleDtos.add(RoleMapper.INSTANCE.toDto(role));
        }
        return roleDtos;
    }

    @Transactional(readOnly = true)
    public RoleDto findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return RoleMapper.INSTANCE.toDto(role.orElse(null));
    }

    @Transactional
    public RoleDto save(RoleDto roleDto) {
        return RoleMapper.INSTANCE.toDto(roleRepository.save(RoleMapper.INSTANCE.toModel(roleDto)));
    }

    @Transactional
    public RoleDto update(Long id, String name) {
        Role role = roleRepository.findById(id).orElse(null);
        role.setRoleName(name);
        return RoleMapper.INSTANCE.toDto(roleRepository.save(role));
    }

    @Transactional
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
