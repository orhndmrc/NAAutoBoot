package main.java.TestNGclassess;

import org.testng.annotations.*;

public class TNG_Group extends TNG_Suite{

    @Test(groups = {"iphone", "faceid"})
    public void testIphoneX(){
        System.out.println("@test1 method");
    }

    @Test(groups = {"iphone", "faceid"})
    public void testIphone11(){
        System.out.println("@test2 method");
    }

    @Test(groups = {"iphone", "touchid"})
    public void testIphone8(){
        System.out.println("@test3 method");
    }

    @Test(groups = {"iphone", "touchid"})
    public void testIphone7(){
        System.out.println("@test4 method");
    }

    @Test(groups = {"android", "oneplus", "faceid"})
    public void testSamsung10(){
        System.out.println("@test5 method");
    }

    @Test(groups = {"android", "samsung"})
    public void testSamsungG9(){
        System.out.println("@test6 method");
    }

    @Test(groups = {"huawei", "faceid"})
    public void testHuawei(){
        System.out.println("@test7 method");
    }
}
