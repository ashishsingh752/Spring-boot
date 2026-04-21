package com.learning.apidevelopment.controller;


import com.learning.apidevelopment.dto.StudentDTO;
import com.learning.apidevelopment.dto.StudentRequestDTO;
import com.learning.apidevelopment.entity.Student;
import com.learning.apidevelopment.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private  final StudentServices studentServices;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        return ResponseEntity.ok(studentServices.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentServices.getStudentsById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentServices.addStudents(studentRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        studentServices.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudentFields(@PathVariable Long id, @RequestBody StudentRequestDTO studentRequestDTO){
        return ResponseEntity.ok(studentServices.updateStudentFields(id, studentRequestDTO));
    }

}
