package ru.aston.course.controller.dto;

import org.junit.jupiter.api.Test;
import ru.aston.course.controller.mapper.FractionMapper;
import ru.aston.course.model.Fraction;

import static org.junit.jupiter.api.Assertions.*;

class FractionDtoTest {
    Fraction fraction;
    public FractionDtoTest() {
        fraction = new Fraction(1L,"fractionName");

    }

    @Test
    void getFractionId() {
        FractionMapper.INSTANCE.toDto(fraction);
        assertEquals(1, FractionMapper.INSTANCE.toDto(fraction).getFractionId());
    }

    @Test
    void setFractionId() {
        FractionMapper.INSTANCE.toDto(fraction);
        FractionDto fractionDto = FractionMapper.INSTANCE.toDto(fraction);
        fractionDto.setFractionId(2L);
        assertEquals(2, fractionDto.getFractionId());
    }

    @Test
    void getFractionName() {
        FractionMapper.INSTANCE.toDto(fraction);
        assertEquals("fractionName", FractionMapper.INSTANCE.toDto(fraction).getFractionName());
    }

    @Test
    void setFractionName() {
        FractionMapper.INSTANCE.toDto(fraction);
        FractionDto fractionDto = FractionMapper.INSTANCE.toDto(fraction);
        fractionDto.setFractionName("newFractionName");
        assertEquals("newFractionName", fractionDto.getFractionName());
    }
    @Test
    void toModel() {
        FractionDto fractionDto = FractionMapper.INSTANCE.toDto(fraction);
        assertEquals(fraction, FractionMapper.INSTANCE.toModel(fractionDto));
    }
}