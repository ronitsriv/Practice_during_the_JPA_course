package com.in28minutes.hibernate.demo1.repository;

import com.in28minutes.hibernate.demo1.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);

    //List<Course> updateCourseById(Long Id);
}
