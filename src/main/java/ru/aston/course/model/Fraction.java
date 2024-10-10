package ru.aston.course.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fractions")
public class Fraction {
    @Id
    @Column(name = "fraction_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long fractionId;

    @Column(name = "fraction_name")
    private String fractionName;

    @ManyToMany(mappedBy = "fractions")
    private List<Hero> heroes;

    public Fraction() {
    }

    public Fraction(Long fractionId, String fractionName) {
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

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public String toString() {
        return "Fraction{" +
               "fractionId=" + fractionId +
               ", fractionName='" + fractionName + '\'' +
               '}';
    }
}
