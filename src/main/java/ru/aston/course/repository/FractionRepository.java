package ru.aston.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.course.model.Fraction;
@Repository ("FractionRepository")
public interface FractionRepository extends JpaRepository<Fraction, Long>{

}
