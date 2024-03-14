package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Guardian;
import com.mishraachandan.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest  // So standard way of doing it is through this. But here we are doing as we want to see the behaviour of our database.
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().firstName("chandan").lastName("mishra").emailId("dummaymail@gmail.com").build();
//                .guardianName("dump").guardianEmail("3EgzyYYbPgL").guardianMobileNbr("GjzKtKG").build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> list = studentRepository.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder().email("d1ItRZL3R").name("HCcMofIW4k").mobileNbr("YjpRgybW2k").build();
        Student student = Student.builder().firstName("uECo1U5GMl8").lastName("n5xEFkE8y").emailId("PowMbR1@gmail.com").guardian(guardian).build();
        studentRepository.save(student);
    }
}