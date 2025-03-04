package com.IFA.dto;

import com.IFA.entity.Student;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;

    // CHANGED: Constructor that maps entity fields to DTO.
    public StudentResponseDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
    }
}
