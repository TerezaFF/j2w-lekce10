package cz.czechitas.java2webapps.lekce10.repository;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByTridaNazev(String nazev);

}
