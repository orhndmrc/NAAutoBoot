package main.java.junitClass;

import org.junit.jupiter.api.*;

public class FirstUnit_Template {
    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - Executed once before all test methods in this class.");
    }
    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - Executed once before each test method in this class.");
    }
    @Test
    void test1() {
        System.out.println("@Test - First test method.");
    }
    @Test
    void test2() {
        System.out.println("@Test - Second test method.");
    }
    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - Executed once after each test method in this class.");
    }
    @AfterAll
    static void done() {
        System.out.println("@AfterAll - Executed once after all test methods in this class.");
    }
}
