package TestCases;

import Base.TestBase;
import Pages.Entityprofilepage;
import Pages.HomePage;
import Pages.LoginPage;
import TestUtils.TestUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class EntityProfilePageTest extends TestBase {
    public EntityProfilePageTest() throws IOException {
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    Entityprofilepage entityprofilepage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        entityprofilepage = new Entityprofilepage();
        // login first
        loginPage.enterData(properties.getProperty("userId"),properties.getProperty("userPassword"));
        loginPage.clickLogin();
    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {
        tearDown(method,result);
    }

    @Test
    public void checkEntityProfileEditData() throws IOException, InterruptedException {
        homePage.clickSettings();
        homePage.clickEntityProfile();
        String temp =  "Your meal with us" + TestUtils.getCounter();
        TestUtils.updateCounter();
        entityprofilepage.updateData(temp);
        entityprofilepage.clickSubmit();
        entityprofilepage.acceptAlert();
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertEquals(entityprofilepage.updatedData().get(0), temp);
    }

}
