package main.java.TestNGclassess;

import org.testng.annotations.*;

public class TNG_Priority extends TNG_Suite{
    //Tests are in alphaphetical order.
    @BeforeClass//similar to @BeforerAll in junit
    public void setUp(){
        System.out.println("@BeforeClass method");
    }
    @AfterClass//similar to @AfterAll in junit
    public void tearDown(){
        System.out.println("@AfterClass method");
    }
    @BeforeMethod//similar to @BeforeEach in junit
    public void init(){
        System.out.println("@BeforeMethod method");
    }
    @AfterMethod//similar to @AfterEach in junit
    public void quit(){
        System.out.println("@AfterMethod method");
    }
    @Test (priority = 3)
    public void test1(){
        System.out.println("@test1 method");
    }
    @Test (priority = 2)
    public void test2(){
        System.out.println("@test2 method");
    }
    @Test(priority = 1)
    public void test3(){
        System.out.println("@test3 method");
    }


}
