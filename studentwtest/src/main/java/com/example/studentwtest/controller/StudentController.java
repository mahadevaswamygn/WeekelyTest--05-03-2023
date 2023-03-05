package com.example.studentwtest.controller;

import com.example.studentwtest.model.Student;
import com.example.studentwtest.service.StudentService;
import jakarta.annotation.Nullable;
import netscape.javascript.JSObject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value = "/student")

    public ResponseEntity<String> postStudent(@RequestBody String student)
    {
        Student student1=setStudents(student);
        studentService.setStudent(student1);
        return new ResponseEntity<String>("student added", HttpStatus.CREATED);
    }

    private Student setStudents(String student) {
        JSONObject jobj = new JSONObject(student);
        Student st = new Student();
        st.setStudentFirstName(jobj.getString("firstName"));
        st.setStudentLastName(jobj.getString("lastName"));
        st.setAge(jobj.getInt("age"));
        st.setActive(jobj.getBoolean("active"));
        st.setAdmissionDate(jobj.getString("admissionDate"));
        return st;
    }
    @GetMapping(value = "/find-student")

    public ResponseEntity<String> getStudent(@Nullable @RequestParam String studentId)
    {
       JSONArray jsrr= studentService.getstudent(studentId);
        return new ResponseEntity<String>(jsrr.toString(),HttpStatus.OK);
    }
    @GetMapping(value = "/student")
    public ResponseEntity<String> getByName(@RequestParam String firstName)
    {
        JSONArray jrr =studentService.findByName(firstName);
        return new ResponseEntity<String>(jrr.toString(),HttpStatus.OK);
    }

}
