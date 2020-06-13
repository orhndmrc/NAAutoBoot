package main.java.TestNGclassess;

import main.java.appCode.AppforTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TNGTestSoftAsserts {
   AppforTest atest = new AppforTest();

    @Test
    public void testSum(){
        int res;
        SoftAssert sa = new SoftAssert();
         res = atest.sumNbrs(1,2);
        sa .assertEquals(res,3 ,"sum mismatch");
        System.out.println("@test1 method");
        sa .assertEquals(res,4 ,"sum mismatch");
        System.out.println("@test-1 method");
        sa .assertEquals(res,6 ,"sum mismatch");
        System.out.println("@test-1 method");
        sa.assertAll("after all assertion complete");
    }
    @Test
    public void testString(){// write and practice the addString to pass and fail.
        String text = atest.addString("Orhan","Demirci");
        Assert.assertEquals(text,"OrhanDemirci1","Check the result");

        System.out.println("@test2 method");
    }
    @Test
    public void test3(){// write and practice the addString to pass and fail.

        System.out.println("@test3 method");
    }


}
