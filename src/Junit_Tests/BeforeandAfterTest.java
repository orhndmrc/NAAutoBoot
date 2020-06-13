package Junit_Tests;

import Junit_Examples.Calculator;
import org.junit.jupiter.api.*;

import java.util.jar.JarOutputStream;

public class BeforeandAfterTest {
    Calculator calc;
    @BeforeAll
    public static void beforeAllMethod(){
        System.out.println("Establishing connection to the database");
    }
    @AfterAll
    public static void afterAllMethod(){
        System.out.println("Closing connection to the database");
    }
    @BeforeEach
    public void init(){
        calc = new Calculator();
        System.out.println("Initializing");
    }
    @Test
    public void testMethod1(){

        int sum = calc.add(10,20);
        System.out.println("The total : "+sum);

    }
    @Test

    public void testMethod2(){

        int sum = calc.add(25,15);
        System.out.println("The total : "+sum);

    }
    @AfterEach
    public void teardown(){
        System.out.println("test method is executed successfully");
    }

}
