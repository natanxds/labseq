package com.bysix.labseq.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class LabseqServiceTest {

    private LabseqService labseqService;

    @BeforeEach
    void setUp() {
        labseqService = new LabseqService();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -3, -22, -90, -1})
    @DisplayName("getLabseq should return bad request when input is negative and correct message")
    void getLabseq_ShouldReturnBadRequest_WhenInputIsNegative(int number) {
        // Arrange
        // Act
        ResponseEntity<Object> result = labseqService.getLabseq(number);

        // Assert
        String expectedMessage = "Number must be positive";
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals(expectedMessage, result.getBody());
    }

    @Test
    @DisplayName("getLabseq should return 3 when input is 10")
    void calculateLabseq_ShouldReturnCorrectValue_WhenInputIsGreaterThanZero() {
        // Arrange
        // Act
        // Assert
        assertEquals(3, labseqService.calculateLabseq(10));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    @DisplayName("calculateLabseq should return the remain of the division when input is greater than zero and less than 4")
    void calculateLabseq_ShouldReturnCorrectValue_WhenInputIsGreaterThanZeroAndLessThanFour(int number) {
        // Arrange
        // Act
        // Assert
        assertEquals(number % 2, labseqService.calculateLabseq(number));
    }

    @Test
    @DisplayName("getLabseq should return before 10 seconds when input is 10000")
    void getLabseq_ShouldReturnCorrectValueUnder10Seconds_WhenInputIs10000() {
        // Arrange
        // Act
        // Assert
        assertTimeout(Duration.ofSeconds(10), () -> {
           labseqService.getLabseq(10000);
        });
    }


}