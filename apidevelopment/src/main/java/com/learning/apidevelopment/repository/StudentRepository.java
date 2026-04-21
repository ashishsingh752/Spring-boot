package com.learning.apidevelopment.repository;

import com.learning.apidevelopment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
