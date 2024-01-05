package com.in28minutes.hibernate.demo1.repository;


import com.in28minutes.hibernate.demo1.entity.Course;
import com.in28minutes.hibernate.demo1.entity.Employee;
import com.in28minutes.hibernate.demo1.entity.Review;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    @Autowired
    EntityManager em;

    public void insert(Employee employee){
        em.persist(employee);
    }

    public List<Employee> retrieveAllEmployees(Long id){

        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }


}
