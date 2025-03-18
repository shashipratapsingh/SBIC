package com.SBICARD.controller;

import com.SBICARD.dto.StudentRequestDTO;
import com.SBICARD.dto.StudentResponseDTO;
import com.SBICARD.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
@ContextConfiguration(classes = { StudentController.class, StudentControllerTest.TestConfig.class })
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class TestConfig {
        @Bean
        @Primary
        public StudentService studentService() {
            return Mockito.mock(StudentService.class);
        }
    }

    @Test
    public void testCreateStudent() throws Exception { // Removed @WithMockUser
        // Arrange
        StudentRequestDTO requestDTO = StudentRequestDTO.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        StudentResponseDTO responseDTO = StudentResponseDTO.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        Mockito.when(studentService.save(any(StudentRequestDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(post("/api/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }
}
