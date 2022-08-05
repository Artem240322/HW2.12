package com.example.hw2_12.service;


import com.example.hw2_12.exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Number plus(Integer a, Integer b) { return a + b; }

    public Number minus(Integer a, Integer b) { return  a - b; }

    public Number multiply(Integer a, Integer b) { return a * b; }

    public Number divide(Integer a, Integer b) {
        if (b == 0) {
            throw new DivideByZeroException("Делить на 0 нельзя!");
        }
        return a.doubleValue() / b;
    }

}
