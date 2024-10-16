package ru.aston.course.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.aston.course.controller.dto.HeroDto;
import ru.aston.course.controller.dto.HeroWithFractionDto;
import ru.aston.course.controller.dto.HeroWithRoleDto;
import ru.aston.course.model.Hero;
import ru.aston.course.model.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeroMapper {
    HeroMapper INSTANCE = Mappers.getMapper(HeroMapper.class);

    HeroDto toDto(Hero hero);

    Hero toModel(HeroDto hero);

    HeroWithFractionDto toDtoWithFraction(Hero hero);

   HeroWithRoleDto toDtoWithRole(Hero hero);
}
