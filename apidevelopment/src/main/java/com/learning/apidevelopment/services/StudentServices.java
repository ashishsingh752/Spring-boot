package com.learning.apidevelopment.services;

import com.learning.apidevelopment.dto.StudentDTO;
import com.learning.apidevelopment.dto.StudentRequestDTO;
import com.learning.apidevelopment.entity.Student;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StudentServices {
    List<StudentDTO> getAllStudents();

    Student addStudents(StudentRequestDTO studentRequestDTO);

    StudentDTO getStudentsById(Long id);

    void deleteStudentById(Long id);

    StudentDTO updateStudentFields(Long id, StudentRequestDTO studentRequestDTO);
}
