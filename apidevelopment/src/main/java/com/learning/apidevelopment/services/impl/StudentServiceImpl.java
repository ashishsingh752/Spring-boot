package com.learning.apidevelopment.services.impl;

import com.learning.apidevelopment.dto.StudentDTO;
import com.learning.apidevelopment.dto.StudentRequestDTO;
import com.learning.apidevelopment.entity.Student;
import com.learning.apidevelopment.repository.StudentRepository;
import com.learning.apidevelopment.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServices {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOList = students.stream().map(student -> modelMapper.map(student, StudentDTO.class)).toList();
        return studentDTOList;
    }

    @Override
    public Student addStudents(StudentRequestDTO studentRequestDTO) {
        return studentRepository.save(modelMapper.map(studentRequestDTO, Student.class));
    }

    @Override
    public StudentDTO getStudentsById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student Not found"));
        StudentDTO studentDTO =  modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updateStudentFields(Long id, StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with given Id"));
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }
}
