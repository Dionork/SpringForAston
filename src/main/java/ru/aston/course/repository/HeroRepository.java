package ru.aston.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.aston.course.model.Hero;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long>{
    List<Hero> findAll();
    void deleteById(Long id);
}
