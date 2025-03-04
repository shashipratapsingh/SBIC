package com.SBICARD.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {
    private String name;
    private String email;
}
