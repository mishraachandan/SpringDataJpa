package com.mishraachandan.springdatajpatutorial.util;

import com.mishraachandan.springdatajpatutorial.entity.Guardian;
import com.mishraachandan.springdatajpatutorial.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class TestDataGenerator {
    private static final String[] FIRST_NAMES = {"John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Ava", "Daniel", "Isabella"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Taylor", "Anderson", "Harris", "Clark", "Allen", "Young", "Scott"};
    private static final String[] DOMAIN = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "example.com"};
    private static final String[] MOBILE_PREFIX = {"+1", "+44", "+61", "+91", "+81"};


    public  List<Student> generateStudents(int count) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= count; i++) {
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + DOMAIN[random.nextInt(DOMAIN.length)];
            String guardianName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] + " " + LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            String guardianEmail = guardianName.toLowerCase().replace(" ", ".") + "@" + DOMAIN[random.nextInt(DOMAIN.length)];
            String mobileNumber = MOBILE_PREFIX[random.nextInt(MOBILE_PREFIX.length)] + (1000000000L + random.nextInt(900000000));

            Guardian guardian = Guardian.builder()
                                        .name(guardianName)
                                        .email(guardianEmail)
                                        .mobileNbr(mobileNumber)
                                        .build();

            Student student = Student.builder()
                                    .firstName(firstName)
                                    .lastName(lastName)
                                    .emailId(email)
                                    .guardian(guardian)
                                    .build();

            students.add(student);
        }
        return students;
    }
}
