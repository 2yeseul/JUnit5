package com.example.junit5test.Assumption;

import com.example.junit5test.Cal.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsDemo {
    private final Calculator calculator = new Calculator();

    @Test
    void testOnlyOnCiServer() {
        //assertEquals("CI", System.getenv("ENV"));
         assumeTrue("CI".equals(System.getenv("ENV"))); // actual : null
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        // assertEquals("DEV", System.getenv("ENV"));
        assumeTrue("DEV".equals(System.getenv("ENV")));
    }

}
