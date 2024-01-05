package com.in28minutes.hibernate.demo1.repository;

import com.in28minutes.hibernate.demo1.Demo1Application;
import com.in28minutes.hibernate.demo1.entity.Course;
import com.in28minutes.hibernate.demo1.entity.Passport;
import com.in28minutes.hibernate.demo1.entity.Student;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = Demo1Application.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;
    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("Student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourses() {
        Student student = em.find(Student.class, 40001L);
        logger.info("student -> {}", student);
        logger.info("student -> {}", student.getCourses() );
    }
    }


