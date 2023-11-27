package TestCases;

import Base.TestBase;
import Pages.CouponPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TaxGroupPage;
import TestUtils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class CouponPageTest extends TestBase {
    public CouponPageTest() throws IOException {
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    CouponPage couponPage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        couponPage = new CouponPage();
        // login first
        loginPage.enterData(properties.getProperty("userId"),properties.getProperty("userPassword"));
        loginPage.clickLogin();
    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {
        tearDown(method,result);
    }


//    @Test()
//    public void addNewCoupon() throws IOException, AWTException, InterruptedException {
//        homePage.clickSettings();
//        homePage.clickCoupon();
//        String temp =  "code" + TestUtils.getCounter() ;
//        TestUtils.updateCounter();
//        couponPage.enterCouponData(temp,"20","5");
//        Thread.sleep(500);
//        driver.navigate().refresh();
//        Thread.sleep(1000);
//        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + temp + "')]"));
//        Assert.assertTrue(list.size() > 0);
//    }

//    @Test()
//    public void updateCouponData() throws IOException, AWTException, InterruptedException {
//        homePage.clickSettings();
//        homePage.clickCoupon();
//        couponPage.clickEdit();
//        couponPage.updateData();
//        Assert.assertTrue(couponPage.updatedData().size() > 0);
//    }

    @Test
    public void ChangeCouponStatus() throws IOException, AWTException, InterruptedException {
        homePage.clickSettings();
        homePage.clickCoupon();
        String temp =  couponPage.getStatus();
        Thread.sleep(500);
        if(temp.equals("check")){
            couponPage.clickChange();
            Thread.sleep(500);
            Assert.assertEquals(couponPage.getStatus() , "xmark");
        }
        else if(temp.equals("xmark")){
            couponPage.clickChange();
            Thread.sleep(500);
            Assert.assertEquals(couponPage.getStatus() , "check");
        }
    }



}
