package main.java.TestNGclassess;

import org.testng.annotations.*;

public class TNG_Class_Method2 extends TNG_Suite{
    //Tests are in alphaphetical order.
    @BeforeClass//similar to @BeforerAll in junit
    public void setUp(){
        System.out.println("Class2-@BeforeClass method");
    }
    @AfterClass//similar to @AfterAll in junit
    public void tearDown(){
        System.out.println("Class2-@AfterClass method");
    }
    @BeforeMethod//similar to @BeforeEach in junit
    public void init(){
        System.out.println("Class2-@BeforeMethod method");
    }
    @AfterMethod//similar to @AfterEach in junit
    public void quit(){
        System.out.println("Class2-@AfterMethod method");
    }
    @Test
    public void test1(){
        System.out.println("Class2-@test1 method");
    }
    @Test
    public void test2(){
        System.out.println("Class2-@test2 method");
    }
    @Test
    public void test3(){
        System.out.println("Class2-@test3 method");
    }


}
