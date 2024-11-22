package com.application.backend.controller;

import com.application.backend.service.CalculatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CalculatorServiceImpl calculatorService;

    @Test
    public void testAdd() throws Exception {
        // Настроим мок для метода add
        when(calculatorService.add(2.0, 3.0)).thenReturn(5.0);

        // Выполняем HTTP POST запрос
        mockMvc.perform(post("/api/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"num1\": 2.0, \"num2\": 3.0}"))
                .andExpect(status().isOk())
                .andExpect(content().json("5.0"));

        // Проверка, что метод add был вызван один раз
        verify(calculatorService, times(1)).add(2.0, 3.0);
    }

    @Test
    public void testSubtract() throws Exception {
        // Настроим мок для метода subtract
        when(calculatorService.subtract(5.0, 3.0)).thenReturn(2.0);

        // Выполняем HTTP POST запрос
        mockMvc.perform(post("/api/calculator/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"num1\": 5.0, \"num2\": 3.0}"))
                .andExpect(status().isOk())
                .andExpect(content().json("2.0"));

        // Проверка, что метод subtract был вызван один раз
        verify(calculatorService, times(1)).subtract(5.0, 3.0);
    }

    @Test
    public void testMultiply() throws Exception {
        // Настроим мок для метода multiply
        when(calculatorService.multiply(2.0, 3.0)).thenReturn(6.0);

        // Выполняем HTTP POST запрос
        mockMvc.perform(post("/api/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"num1\": 2.0, \"num2\": 3.0}"))
                .andExpect(status().isOk())
                .andExpect(content().json("6.0"));

        // Проверка, что метод multiply был вызван один раз
        verify(calculatorService, times(1)).multiply(2.0, 3.0);
    }

    @Test
    public void testDivide() throws Exception {
        // Настроим мок для метода divide
        when(calculatorService.divide(6.0, 3.0)).thenReturn(2.0);

        // Выполняем HTTP POST запрос
        mockMvc.perform(post("/api/calculator/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"num1\": 6.0, \"num2\": 3.0}"))
                .andExpect(status().isOk())
                .andExpect(content().json("2.0"));

        // Проверка, что метод divide был вызван один раз
        verify(calculatorService, times(1)).divide(6.0, 3.0);
    }
}

