package com.pondit;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class FirstMissingPositiveTest {

    private FirstMissingPositive instance;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        instance = new FirstMissingPositive();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void firstMissingPositive() {
        Assertions.assertEquals(2, instance.firstMissingPositive(new int[] {1}));
        Assertions.assertEquals(1, instance.firstMissingPositive(new int[] {0}));
        Assertions.assertEquals(1, instance.firstMissingPositive(new int[] {-3, -2, -1}));
        Assertions.assertEquals(3, instance.firstMissingPositive(new int[] {1,2,0}));
        Assertions.assertEquals(2, instance.firstMissingPositive(new int[] {3,4,-1,1}));
        Assertions.assertEquals(1, instance.firstMissingPositive(new int[] {7,8,9,11,12}));
        Assertions.assertEquals(1, instance.firstMissingPositive(new int[] {-1,-2,-60,40,43}));
        Assertions.assertEquals(2, instance.firstMissingPositive(new int[] {1,1}));
        Assertions.assertEquals(1, instance.firstMissingPositive(new int[] {1000,-1}));
    }
}