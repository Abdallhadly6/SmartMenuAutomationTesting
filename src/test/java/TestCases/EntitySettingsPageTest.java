package TestCases;

import Base.TestBase;
import Pages.EntitySettingsPage;
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

public class EntitySettingsPageTest extends TestBase {
    public EntitySettingsPageTest() throws IOException {
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    EntitySettingsPage entitySettingsPage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        entitySettingsPage = new EntitySettingsPage();
        // login first
        loginPage.enterData(properties.getProperty("userId"),properties.getProperty("userPassword"));
        loginPage.clickLogin();
    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {
        tearDown(method,result);
    }

    @Test
    public void checkEntitySettingsEditData() throws IOException, InterruptedException {
        homePage.clickSettings();
        homePage.clickEntitySettings();
        String temp =  "Your meal with us" + TestUtils.getCounter();
        TestUtils.updateCounter();
        entitySettingsPage.updateData(temp);
        entitySettingsPage.clickSubmit();
        entitySettingsPage.acceptAlert();
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertEquals(entitySettingsPage.updatedData().get(0), temp);
    }

}

