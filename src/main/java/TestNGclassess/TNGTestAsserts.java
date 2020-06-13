package main.java.TestNGclassess;

import main.java.appCode.AppforTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TNGTestAsserts {
   AppforTest atest = new AppforTest();

    @Test
    public void testSum(){
        int res = atest.sumNbrs(1,2);
        Assert.assertEquals(res,3 ,"sum mismatch");
        System.out.println("@test1 method");
    }
    @Test
    public void testString(){// write and practice the addString to pass and fail.
        String text = atest.addString("Orhan","Demirci");
        Assert.assertEquals(text,"OrhanDemirci","Check the result");

        System.out.println("@test2 method");
    }
    @Test
    public void test3(){// write and practice the addString to pass and fail.

        System.out.println("@test3 method");
    }


}
