package com.IFA.repository;

import com.IFA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> { // CHANGED: Use Long as primary key type.
}
