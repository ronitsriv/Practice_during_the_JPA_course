package com.in28minutes.hibernate.demo1.repository;


import com.in28minutes.hibernate.demo1.entity.Course;
import com.in28minutes.hibernate.demo1.entity.Passport;
import com.in28minutes.hibernate.demo1.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class, id);
    }

    public void deleteById(Long id){
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student){
        if(student.getId() == null){
            em.persist(student);
        } else{
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z1234567");
        em.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }

    public void insertHardCodedStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
    }
}
