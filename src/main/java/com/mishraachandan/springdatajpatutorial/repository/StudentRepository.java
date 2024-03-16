package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // Spring will understand that the interface we created is repository interface.
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Defining custom method
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    public List<Student> findByFirstNameContaining(String firstName);
    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String name);

    // jpql based query.
    // So this are defined based on the class that you have created.
    @Query(value = "Select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String email);



}
