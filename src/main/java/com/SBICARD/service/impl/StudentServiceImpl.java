package com.SBICARD.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentResponseDTO save(StudentRequestDTO request) {
        // CHANGED: Map DTO to entity using builder.
        Student student = Student.builder().name(request.getName()).email(request.getEmail()).build();

        Student savedStudent = studentRepository.save(student);
        // Convert the saved entity to a response DTO.
        return new StudentResponseDTO(savedStudent);
    }
}
