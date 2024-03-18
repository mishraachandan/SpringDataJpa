package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Course;
import com.mishraachandan.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course
                 = Course.builder().title("Dsa").credit(5).build();

        Course course2
                = Course.builder().title("Java").credit(10).build();
        Teacher teacher = Teacher.builder().firstName("Chand").lastName("mishra").build();
        teacherRepository.save(teacher);
    }
}