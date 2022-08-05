package com.example.hw2_12.service;


import com.example.hw2_12.exception.DivideByZeroException;
import org.junit.jupiter.api.Test;



public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        Number actual = calculatorService.plus(2, 3);
        assertThat(actual).isEqualTo(5);

        actual = calculatorService.plus(-3, 1);
        assertThat(actual).isEqualTo(-2);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorService.minus(2, 3);
        assertThat(actual).isEqualTo(-1);

        actual = calculatorService.minus(-3, 1);
        assertThat(actual).isEqualTo(-4);
    }
    @Test
    public void multiplyTest() {
        Number actual = calculatorService.multiply(2, 3);
        assertThat(actual).isEqualTo(6);

        actual = calculatorService.multiply(-3, 1);
        assertThat(actual).isEqualTo(-3);
    }
    @Test
    public void dividePositiveTest() {
        Number actual = calculatorService.divide(1, 2);
        assertThat(actual).isEqualTo(0.5);

        actual = calculatorService.divide(-3, 1);
        assertThat(actual).isEqualTo(-30);
    }

    @Test
    public void divideNegativeTest() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(1, 0))
                .withMessage("Делить на 0 нельзя!");

        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(-1, 0))
                .withMessage("Делить на 0 нельзя!");

    }
}
