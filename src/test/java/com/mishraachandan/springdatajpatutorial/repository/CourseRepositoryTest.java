package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Course;
import com.mishraachandan.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest{

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCourseData(){
        List<?> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder().firstName("suman").lastName("sahu").build();
        Course course = Course.builder().title("Intro to AI").credit(10).teacher(teacher).build();
        courseRepository.save(course);


    }
}