package com.example.testinglab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

public class test2Test {
    test2 test;

    @Nested
    class max {
        @BeforeEach
        public void before () {
            test = new test2();
        }
        @Test
        public void expectedFive () {
            int[] array = {0, 3, 5, 1, -8};
            assertEquals(5, test.FindMax(array));
        }
        @Test
        public void expectedHundred() {
            int[] array = {100, 35, -10000, 19, 99};
            assertEquals(100, test.FindMax(array));
        }
        @Test
        public void expectedNegOne() {
            int[] array = {-6, -4, -11, -3, -1};
            assertEquals(-1, test.FindMax(array));
        }
    }
    @Nested
    class min {
        @BeforeEach
        public void before () {
            test = new test2();
        }
        @Test
        public void expectedNegEight () {
            int[] array = {0, 3, 5, 1, -8};
            assertEquals(-8, test.FindMin(array));
        }
        @Test
        public void expectedTen() {
            int[] array = {100, 35, 10, 19, 99};
            assertEquals(10, test.FindMin(array));
        }
        @Test
        public void expectedNegEleven() {
            int[] array = {-6, -4, -11, -3, -1};
            assertEquals(-11, test.FindMin(array));
        }
        @Test
        public void expectedZero() {
            int[] array = {2, 4, 1, 9, 0};
            assertEquals(0, test.FindMin(array));
        }
    }

    @AfterEach
    public void after () {
        test = null;
    }
}
