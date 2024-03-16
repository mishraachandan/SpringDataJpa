package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Guardian;
import com.mishraachandan.springdatajpatutorial.entity.Student;
import com.mishraachandan.springdatajpatutorial.util.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest  // So standard way of doing it is through this. But here we are doing as we want to see the behaviour of our database.
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestDataGenerator testDataGenerator;

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
        Student student = Student.builder().firstName("uECo1U5GMl8").lastName("n5xEFkE8y").emailId("PowMbR1@gmail.com").guardian
                (guardian).build();
        studentRepository.save(student);

    }

    @Test
    public void addingDummyDataIntoTable(){
        List<Student> studentList = testDataGenerator.generateStudents(50);
        for(Student student : studentList){
            studentRepository.save(student);
        }
    }

    @Test
    public void getStudentByFirstAndLastName(){
        List<Student> studentList =  studentRepository.findByFirstNameAndLastName("uECo1U5GMl8", "n5xEFkE8y");
        studentList.stream()
                .map(x -> x.getLastName() + " " + x.getFirstName())
                .forEach(System.out::println);
    }

    @Test
    public void getStudentFirstNameContains(){
        List<Student> studentList =  studentRepository.findByFirstNameContaining("u");
        studentList.stream().map(x-> x.getFirstName() + " " + x.getLastName()).forEach(System.out::println);
    }

    @Test
    public void getStudentLastNameNotNull(){
        List<Student> studentList =  studentRepository.findByLastNameNotNull();
        studentList.forEach(System.out::println);
    }

    @Test
    public void getStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("HCcMofIW4k");
        studentList.stream().map(x -> x.getFirstName()).forEach(System.out::println);
    }






}