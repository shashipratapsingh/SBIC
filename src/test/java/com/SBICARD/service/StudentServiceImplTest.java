package com.SBICARD.service;

import com.SBICARD.dto.StudentRequestDTO;
import com.SBICARD.dto.StudentResponseDTO;
import com.SBICARD.entity.Student;
import com.SBICARD.repository.StudentRepository;
import com.SBICARD.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        // Initializes the mocks before each test.
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        // Arrange: Create a sample request DTO.
        StudentRequestDTO request = StudentRequestDTO.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        // Arrange: Create a sample Student entity to be returned by the repository.
        Student student = Student.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        // Use Mockito to stub the repository save method.
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        // Act: Call the service save method.
        StudentResponseDTO response = studentService.save(request);

        // Assert: Verify the response fields are correctly mapped.
        assertNotNull(response, "Response should not be null");
        assertEquals(1L, response.getId(), "ID should match the saved student's ID");
        assertEquals("John Doe", response.getName(), "Name should match");
        assertEquals("john.doe@example.com", response.getEmail(), "Email should match");
    }
}
