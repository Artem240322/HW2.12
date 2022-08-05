package com.example.hw2_12.service;


import com.example.hw2_12.exception.DivideByZeroException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParameterizedCalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("paramsForPlus")
    public void plusTest(Integer a,
                         Integer b,
                         Integer expected) {
        assertThat(calculatorService.plus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest(Integer a,
                          Integer b,
                          Integer expected) {
        assertThat(calculatorService.minus(a, b)) .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("paramsForMultiply")
    public void multiplyTest(Integer a,
                          Integer b,
                          Integer expected) {
        assertThat(calculatorService.multiply(a, b)) .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivide")
    public void divideTest(Integer a,
                          Integer b,
                          Double expected) {
        if (b == 0) {
        assertThatExceptionOfType(DivideByZeroException.class
                .isThrownBy(() -> calculatorService.divide(a, b))
                .withMassager("Делить на ноль нельзя!");
        } else {
            assertThat(calculatorService.divide(a, b)) .isEqualTo(expected);
        }
    }

    public static Stream<Arguments> paramsForPlus() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 2, 1),
                Arguments.of(-10, -6, 16),
                Arguments.of(1, -5, -4),
                Arguments.of(0, 0, 0)
        );
    }

    public static Stream<Arguments> paramsForMinus() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(-1, 2, -3),
                Arguments.of(-10, -6, -4),
                Arguments.of(1, -5, 6),
                Arguments.of(0, 0, 0)
        );
    }

    public static Stream<Arguments> paramsForMultiply() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(-1, 2, 2),
                Arguments.of(-10, -6, 60),
                Arguments.of(1, -5, -5),
                Arguments.of(0, 0, 0)
        );
    }

    public static Stream<Arguments> paramsForDivide() {
        return Stream.of(
                Arguments.of(1, 2, 0.5),
                Arguments.of(-1, 2, -0.5),
                Arguments.of(-10, -6, 50 / 3),
                Arguments.of(1, -5, -0.2),
                Arguments.of(1, 0, null),
                Arguments.of(-1, 0, null)
        );
    }



}
