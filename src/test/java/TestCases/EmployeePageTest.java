package TestCases;

import Base.TestBase;
import Pages.EmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import TestUtils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class EmployeePageTest extends TestBase {
    public EmployeePageTest() throws IOException {
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    EmployeePage employeePage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        employeePage = new EmployeePage();

    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {
        tearDown(method,result);
    }

//    @Test()
//    public void addNewEmployee() throws IOException, AWTException, InterruptedException {
//        // login first
//        loginPage.enterData(properties.getProperty("userId"),properties.getProperty("userPassword"));
//        loginPage.clickLogin();
//
//        String temp1 = TestUtils.getCounter() + "unique1";
//        String temp2 = TestUtils.getCounter() + "auto2@test.com";
//        TestUtils.updateCounter();
//        homePage.clickSettings();
//        homePage.clickAddEmployee();
//        employeePage.enterUserData("abdallh",temp1,temp2,"Test@123","Test@123","0524875455");
//        employeePage.clickSubmit();
//        employeePage.acceptAlert();
//        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + temp1 + "')]"));
//        Assert.assertTrue(list.size() > 0);
//    }

//    @Test
//    public void ChangeEmployeeStatus() throws IOException, AWTException, InterruptedException {
//        // login first
//        loginPage.enterData(properties.getProperty("userId"),properties.getProperty("userPassword"));
//        loginPage.clickLogin();
//
//        homePage.clickSettings();
//        homePage.clickAddEmployee();
//        employeePage.clickChange();
//
//        String temp =  employeePage.getStatus();
//        if(temp.equals("check")){
//            homePage.clickLogOut();
//            //login as manager
//            loginPage.enterData("supervisor",properties.getProperty("userPassword"));
//            loginPage.clickLogin();
//            Assert.assertTrue(homePage.getLogOutLink());
//        }
//        else if(temp.equals("xmark")){
//            homePage.clickLogOut();
//            //login as manager
//            loginPage.enterData("supervisor",properties.getProperty("userPassword"));
//            loginPage.clickLogin();
//            employeePage.acceptAlert();
//            Assert.assertTrue(loginPage.getForgetPass());
//        }
//    }


    @Test()
    public void updateUserData() throws IOException, AWTException, InterruptedException {
        // login first
        loginPage.enterData(properties.getProperty("userId"),properties.getProperty("userPassword"));
        loginPage.clickLogin();

        homePage.clickSettings();
        homePage.clickAddEmployee();
        employeePage.clickEdit();
        employeePage.updateData();
        Assert.assertTrue(employeePage.updatedData().size() > 0);
    }

}
