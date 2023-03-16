package com.backendmarch.librarymanagementsystem.Repository;

import com.backendmarch.librarymanagementsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    //findBy{attribute}.
    Student findByEmail(String email);   // make the custom Query attribute.

    List<Student> findByAge(int age);
}



