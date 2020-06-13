package Junit_Tests;

import Junit_Examples.Calculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestAnnotationTest {
    @Test
    @DisplayName("Adding 2 Positive Numbers")
    public void testMethod1(){
        Calculator calc = new Calculator();
        int sum = calc.add(10,20);
        System.out.println("The total : "+sum);

    }
    @Test
    @Disabled("execution will be disabled")
    public void testMethod2(){
        Calculator calc = new Calculator();
        int sum = calc.add(25,15);
        System.out.println("The total : "+sum);

    }

}
