package com.application.backend.controller;

import com.application.backend.dto.OperationDto;
import com.application.backend.service.CalculatorService;
import com.application.backend.service.CalculatorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/calculator")
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorServiceImpl calculatorService;

    @PostMapping("/add")
    public ResponseEntity<Double> add(@RequestBody OperationDto operationDto) {
        return ResponseEntity.ok(calculatorService.add(operationDto.getNum1(), operationDto.getNum2()));
    }

    @PostMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestBody OperationDto operationDto) {
        return ResponseEntity.ok(calculatorService.subtract(operationDto.getNum1(), operationDto.getNum2()));
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody OperationDto operationDto) {
        return ResponseEntity.ok(calculatorService.multiply(operationDto.getNum1(), operationDto.getNum2()));
    }

    @PostMapping("/divide")
    public ResponseEntity<Double> divide(@RequestBody OperationDto operationDto) {
        return ResponseEntity.ok(calculatorService.divide(operationDto.getNum1(), operationDto.getNum2()));
    }
}
