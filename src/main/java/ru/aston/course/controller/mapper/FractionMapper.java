package ru.aston.course.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.aston.course.controller.dto.FractionDto;
import ru.aston.course.model.Fraction;

@Mapper(componentModel = "spring")
public interface FractionMapper {
    FractionMapper INSTANCE = Mappers.getMapper(FractionMapper.class);
    FractionDto toDto(Fraction fraction);
    Fraction toModel (FractionDto fractionDto);
}
