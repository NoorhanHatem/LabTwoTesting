package com.example.testinglab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

public class test1Test {

    test test;

    @Nested
    class even {
        @BeforeEach
        public void before () {
            test = new test();
        }
        @Test
        public void twoExpectedEven() {
            assertEquals("Even", test.checkEvenAndOdd(2));
        }
        @Test
        public void hundredExpectedEven() {
            assertEquals("Even", test.checkEvenAndOdd(100));
        }
        @Test
        public void negTwentyExpectedEven() {
            assertEquals("Even", test.checkEvenAndOdd(-20));
        }
        @Test
        public void negEightyExpectedEven() {
            assertEquals("Even", test.checkEvenAndOdd(-80));
        }
    }
    @Nested
    class odd {
        @BeforeEach
        public void before () {
            test = new test();
        }
        @Test
        public void oneExpectedOdd() {
            assertEquals("Odd", test.checkEvenAndOdd(1));
        }
        @Test
        public void ninetynineExpectedOdd() {
            assertEquals("Odd", test.checkEvenAndOdd(99));
        }
        @Test
        public void neghundredoneExpectedOdd() {
            assertEquals("Odd", test.checkEvenAndOdd(-101));
        }
        @Test
        public void negSevenExpectedOdd() {
            assertEquals("Odd", test.checkEvenAndOdd(-7));
        }
        @Test
        public void onePointoneExpectedOdd() {
            assertEquals("Odd", test.checkEvenAndOdd(1.1));
        }
    }

    @AfterEach
    public void after () {
        test = null;
    }
}