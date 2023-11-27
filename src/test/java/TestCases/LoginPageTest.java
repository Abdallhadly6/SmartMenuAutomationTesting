package TestCases;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import TestUtils.TestUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginPageTest extends TestBase {
    public LoginPageTest() throws IOException {
        super();
    }

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {
        tearDown(method,result);
    }


    @Test( dataProvider = "validUserAndPassword")
    public void validUserIdAndPassword(String user , String pass) throws IOException {
        loginPage.enterData(user,pass);
        loginPage.clickLogin();
        Assert.assertTrue(homePage.getLogOutLink());
    }


    @Test(dataProvider = "InValidUserAndPassword")
    public void InValidUserIdAndPassword(String user , String pass) throws IOException, InterruptedException {
        loginPage.enterData(user,pass);
        loginPage.clickLogin();
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.getForgetPass());

    }

    @Test(dataProvider = "InValidUserAndValidPassword")
    public void inValidUserIdAndValidPassword(String user , String pass) throws IOException, InterruptedException {
        loginPage.enterData(user,pass);
        loginPage.clickLogin();
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.getForgetPass());
    }

    @Test( dataProvider = "validUserAndInValidPassword")
    public void validUserIdAnInValidPassword(String user , String pass) throws IOException, InterruptedException {
        loginPage.enterData(user,pass);
        loginPage.clickLogin();
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.getForgetPass());
    }




    @DataProvider
    public Object[][] validUserAndPassword() throws IOException {
        Object[][] data = TestUtils.getDatFromExcel("vailduserandpassword");
        return data;

    }

    @DataProvider
    public Object[][] InValidUserAndPassword() throws IOException {
        Object[][] data = TestUtils.getDatFromExcel("invailduserandpassword");
        return data;

    }

    @DataProvider
    public Object[][] InValidUserAndValidPassword() throws IOException {
        Object[][] data = TestUtils.getDatFromExcel("invailduserandvalidpassword");
        return data;

    }

    @DataProvider
    public Object[][] validUserAndInValidPassword() throws IOException {
        Object[][] data = TestUtils.getDatFromExcel("vailduserandinvalidpassword");
        return data;

    }

}
