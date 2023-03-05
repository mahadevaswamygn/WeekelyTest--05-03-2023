package com.example.studentwtest.service;

import com.example.studentwtest.dao.StudentRepository;
import com.example.studentwtest.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void setStudent(Student student) {
        studentRepository.save(student);

    }

    public JSONArray getstudent(String studentId) {
        JSONArray jsonArray=new JSONArray();
        if(studentId != null)
        {
            Student student=studentRepository.findById(String.valueOf(studentId)).get();
            if(studentId != null) {
                JSONObject jobj = setStudents(student);
                jsonArray.put(jobj);
            }

        }
        else {
            List<Student> studentList = studentRepository.findAll();
            for (Student student:studentList) {
                JSONObject jsonObject=new JSONObject();
                jsonObject=setStudents(student);
                jsonArray.put(jsonObject);

            }

        }
        return jsonArray;
    }

    private JSONObject setStudents(Student student) {
        JSONObject jobj=new JSONObject();
        jobj.put("studentId",student.getStudentId());
        jobj.put("studentFirstName",student.getStudentFirstName());
        jobj.put("studentLastNAme",student.getStudentLastName());
        jobj.put("age",student.getAge());
        jobj.put("admissionDate",student.getAdmissionDate());
        jobj.put("active",student.getActive());
        return jobj;
    }

    public JSONArray findByName(String firstName) {
        JSONArray jsonArray=new JSONArray();
        List<Student> studentList=studentRepository.findByName(firstName);
        for (Student student:studentList) {
            JSONObject jobj = setStudents(student);
            jsonArray.put(jobj);

        }
        return jsonArray;
    }
}
