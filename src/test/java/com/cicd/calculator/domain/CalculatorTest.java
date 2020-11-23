package com.cicd.calculator.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void setAndGetFirstValue() {
        calculator.setFirstValue(20);
        assertEquals(20, calculator.getFirstValue());
    }

    @Test
    void setAndGetSecondValue() {
        calculator.setSecondValue(30);
        assertEquals(30, calculator.getSecondValue());
    }

    @Test
    void addPositives() {
        assertEquals(2, calculator.Add(1, 1));
    }

    @Test
    void addNegativePositive() {
        assertEquals(0, calculator.Add(1, -1));
    }

    @Test
    void addToVeryBigNumber(){
        assertEquals(Integer.MIN_VALUE, calculator.Add(Integer.MAX_VALUE, 1));
    }

    @Test
    void subtractPositives() {
        assertEquals(5, calculator.Subtract(7, 2));
    }

    @Test
    void subtractPositiveAndNegative() {
        assertEquals(-9, calculator.Subtract(-7, 2));
    }

    @Test
    void subtractFromVeryBigNumber(){
        assertEquals(Integer.MAX_VALUE, calculator.Subtract(Integer.MIN_VALUE, 1));
    }

    @Test
    void multiplyPositives() {
        assertEquals(30, calculator.Multiply(6, 5));
    }

    @Test
    void multiplyPositiveAndNegative() {
        assertEquals(-30, calculator.Multiply(-6, 5));
    }

    @Test
    void dividePositives() {
        assertEquals(7, calculator.Divide(28, 4));
    }

    @Test
    void dividePositiveAndNegative() {
        assertEquals(-7, calculator.Divide(-28, 4));
    }

    @Test
    void divideWithZero() {
        assertEquals(0, calculator.Divide(28, 0));
    }

    @Test
    void expectCorrectDecimals(){
        assertEquals(2.5, calculator.Divide(5, 2), 0.0);
    }
}