package com.IFA.service;

import com.IFA.dto.StudentRequestDTO;
import com.IFA.dto.StudentResponseDTO;

public interface StudentService {
    StudentResponseDTO save(StudentRequestDTO request);
}
