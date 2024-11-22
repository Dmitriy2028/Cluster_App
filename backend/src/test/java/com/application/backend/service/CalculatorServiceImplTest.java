package com.application.backend.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    public void testAdd() {
        // Проверка сложения
        double result = calculatorService.add(2.0, 3.0);
        assertEquals(5.0, result);
    }

    @Test
    public void testSubtract() {
        // Проверка вычитания
        double result = calculatorService.subtract(5.0, 3.0);
        assertEquals(2.0, result);
    }

    @Test
    public void testMultiply() {
        // Проверка умножения
        double result = calculatorService.multiply(2.0, 3.0);
        assertEquals(6.0, result);
    }

    @Test
    public void testDivide() {
        // Проверка деления
        double result = calculatorService.divide(6.0, 3.0);
        assertEquals(2.0, result);
    }
}
