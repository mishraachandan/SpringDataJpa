package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Course;
import com.mishraachandan.springdatajpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course
                 = Course.builder().credit(10).title("Dsa").build();
        CourseMaterial courseMaterial
                 = CourseMaterial.builder().url("www.google.com.course").course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void fetchAllTheCourseMaterial(){
        List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
        System.out.println(courseMaterial);
    }



}