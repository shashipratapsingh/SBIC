package com.SBICARD.service;

import com.SBICARD.dto.StudentRequestDTO;
import com.SBICARD.dto.StudentResponseDTO;

public interface StudentService {
    StudentResponseDTO save(StudentRequestDTO request);
}
