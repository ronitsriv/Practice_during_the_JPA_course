package com.in28minutes.hibernate.demo1.repository;

import com.in28minutes.hibernate.demo1.Demo1Application;
import com.in28minutes.hibernate.demo1.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = Demo1Application.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;


    @Test
    public void findById_Basic() {
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_Basic() {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void save_Basic() {
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
        course.setName("JPA in 50 Steps - Updated");
        repository.save(course);

        Course course1 = repository.findById(10001L);
        assertEquals("JPA in 50 Steps - Updated", course1.getName());


    }

}
