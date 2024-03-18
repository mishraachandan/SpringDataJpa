package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    // So these are defined based on the class that you have created.
    @Query(value = "Select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String email);


    //native query
    @Query(value = "SELECT * FROM student s where s.guardian_email = ?1", nativeQuery = true)
    Student getStudentByNativeQuery(String email);

    @Query(value = "SELECT s.email_id FROM student s where s.first_name = :firstName", nativeQuery = true)
    List<String> getStudentByFirstNameNative(@Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query(value = "Update student set first_name = :firstName where email_id = :email", nativeQuery = true)
    int updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("email") String email);

}
