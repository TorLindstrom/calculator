package com.cicd.calculator.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@Disabled
class InsprirationTest {

    static Inspriration inspriration;

    @BeforeAll
    static void setUp() {
        inspriration = new Inspriration();
    }

    @RepeatedTest(10)
    void quote() {
        String quote = inspriration.Quote();
        assertAll(() -> assertNotNull(quote),
                () -> assertFalse(quote.isEmpty()));
    }

    @Test
    void updateAndGetCallCounter() {
        inspriration.Quote();
        int firstCallCounter = inspriration.getCallCounter();
        assertTrue(firstCallCounter >= 0);
        inspriration.Quote();
        assertTrue(inspriration.getCallCounter() > firstCallCounter);
    }
}