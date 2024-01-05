package com.in28minutes.hibernate.demo1.repository;

import com.in28minutes.hibernate.demo1.Demo1Application;
import com.in28minutes.hibernate.demo1.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = Demo1Application.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;


    @Test
    public void findById_Basic() {
        Query query = em.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("Select c from Course c -> {}", resultList);
    }

    @Test
    public void findById_typed() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List resultList = query.getResultList();
        logger.info("Select c from Course c -> {}", resultList);
    }

    @Test
    public void jpql_courses_without_students(){
        TypedQuery<Course> query = em.createQuery("Select c, s from Course c JOIN c.students s", Course.class);
    }

}
