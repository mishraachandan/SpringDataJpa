package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Spring will understand that the interface we created is repository interface.
public interface StudentRepository extends JpaRepository<Student, Long> {

}
