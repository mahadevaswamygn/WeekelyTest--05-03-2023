package com.example.studentwtest.dao;

import com.example.studentwtest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    @Query(value = "SELECT * FROM tbl_student where first_name = :firstname ",nativeQuery = true)
    public List<Student> findByName(String firstname);
}
