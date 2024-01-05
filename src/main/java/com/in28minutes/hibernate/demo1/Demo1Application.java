package com.in28minutes.hibernate.demo1;

import com.in28minutes.hibernate.demo1.entity.Course;
import com.in28minutes.hibernate.demo1.entity.FullTimeEmployee;
import com.in28minutes.hibernate.demo1.entity.PartTimeEmployee;
import com.in28minutes.hibernate.demo1.repository.CourseRepository;
import com.in28minutes.hibernate.demo1.repository.CourseSpringDataRepository;
import com.in28minutes.hibernate.demo1.repository.EmployeeRepository;
import com.in28minutes.hibernate.demo1.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    CourseSpringDataRepository courseSpringDataRepository;
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("1000")));
        //employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
        //courseRepository.addReviewsForCourse();
        List<Course> coursesWithNameS = courseSpringDataRepository.findByName("Spring in 50 Steps");

        // Do something with the retrieved courses
        for (Course course : coursesWithNameS) {
            logger.info("Found course with name '{}'", course.getName());
        }
    }
}
