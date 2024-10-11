package ru.aston.course.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "heroes")
public class Hero {
    @Id
    @Column(name = "hero_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long heroId;
    @Column(name = "hero_name")
    private String heroName;
    @Column(name = "hero_lastname")
    private String heroLastName;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "role_name_id", referencedColumnName = "role_name_id")
    private Role role;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "heroes_fractions",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "fraction_id"))
    private List<Fraction> fractions;


    public Hero() {
    }

    public Hero(Long heroId, String heroName, String heroLastName) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroLastName = heroLastName;
    }

    public Long getHeroId() {
        return heroId;
    }

    public void setHeroId(Long heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroLastName() {
        return heroLastName;
    }

    public void setHeroLastName(String heroLastName) {
        this.heroLastName = heroLastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Fraction> getFractions() {
        return fractions;
    }

    public void setFractions(List<Fraction> fractions) {
        this.fractions = fractions;
    }
}
