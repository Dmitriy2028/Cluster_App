package com.application.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Double add (double num1, double num2){
        return num1+num2;
    }

    @Override
    public Double subtract (double num1, double num2){
        return num1-num2;
    }

    @Override
    public Double multiply (double num1, double num2){
        return num1*num2;
    }

    @Override
    public Double divide (double num1, double num2){
        return num1/num2;
    }

}
