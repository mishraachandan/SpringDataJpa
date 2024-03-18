package com.mishraachandan.springdatajpatutorial.repository;

import com.mishraachandan.springdatajpatutorial.entity.Course;
import com.mishraachandan.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCourseData() {
        List<?> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder().firstName("suman").lastName("sahu").build();
        Course course = Course.builder().title("Intro to AI").credit(10).teacher(teacher).build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(0, 2);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        List<Course> coursesTwo = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        List<Course> courseList = courseRepository.findAll();
        // only the three records
        System.out.println(courses);

        System.out.println("-----------------------------");
        // all the records
        System.out.println(courseList);

        // two records
        System.out.println("-----------------------------");
        System.out.println(coursesTwo);

    }

    @Test
    public void setSortByTitle() {
        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2,Sort.by("title").descending()
                .and(Sort.by("credit")));
        List<Course> coursesByTitle = courseRepository.findAll(sortByTitle).getContent();
        List<Course> coursesByCreditDesc = courseRepository.findAll(sortByCreditDesc).getContent();
        List<Course> coursesByTitleAndCreditDesc = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println(coursesByTitle);
        System.out.println(coursesByCreditDesc);
        System.out.println(coursesByTitleAndCreditDesc);

    }


}