package ru.aston.course.controller.dto;


public class FractionDto {

    private Long fractionId;

    private String fractionName;

    public FractionDto(Long fractionId, String fractionName) {
        this.fractionId = fractionId;
        this.fractionName = fractionName;
    }

    public Long getFractionId() {
        return fractionId;
    }

    public void setFractionId(Long fractionId) {
        this.fractionId = fractionId;
    }

    public String getFractionName() {
        return fractionName;
    }

    public void setFractionName(String fractionName) {
        this.fractionName = fractionName;
    }
}
