package com.pondit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestingExampleTest {

    private UnitTestingExample unitTestingExample;
    @BeforeEach
    void setUp() {
        unitTestingExample = new UnitTestingExample();
        unitTestingExample.setName("Mainul");
    }

    @Test
    public void mustReturnMyName () {
        Assertions.assertEquals("Mainul", unitTestingExample.getName(), "Name matched successfully");
    }
}