package com.example.studentwtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int StudentId;
    @Column(name = "first_name")
    private String studentFirstName;
    @Column(name = "last_name")
    private String studentLastName;
    @Column(name = "age")
    private int age;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "admission_date")
    private String admissionDate;
}
