package com.in28minutes.hibernate.demo1.repository;


import com.in28minutes.hibernate.demo1.entity.Course;
import com.in28minutes.hibernate.demo1.entity.Review;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course){
        if(course.getId() == null){
            em.persist(course);
        } else{
            em.merge(course);
        }
        return course;
    }

//    public void playWithEntityManager(){
//        Course course1 = new Course("Web Services in 100 steps");
//        em.persist(course1);
//
//        Course course2 = findById(10001L);
//        course2.setName("JPA in 50 Steps - Updated");
//        //course1.setName(null);
//    }

    public void addReviewsForCourse() {
        Course course = findById(10003L);
        //logger.info
        Review review1 = new Review("5", "Great");
        Review review2 = new Review("5", "Hatsoff");

        course.addReview(review1);
        review1.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);
        em.persist(review1);
        em.persist(review2);
    }
}
