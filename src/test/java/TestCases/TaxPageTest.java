package TestCases;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TaxPage;
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

public class TaxPageTest extends TestBase {
    public TaxPageTest() throws IOException {
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    TaxPage taxPage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        taxPage = new TaxPage();
        // login first
        loginPage.enterData(properties.getProperty("userId"),properties.getProperty("userPassword"));
        loginPage.clickLogin();
    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {
        tearDown(method,result);
    }

    @Test()
    public void addNewTax() throws IOException , InterruptedException {
        homePage.clickSettings();
        homePage.clickTax();
        String temp = TestUtils.getCounter() + "test";
        TestUtils.updateCounter();
        taxPage.enterTaxeData("اختبار",temp , "25");
        taxPage.clickSubmit();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + temp + "')]"));
        Assert.assertTrue(list.size() > 0);
    }

    @Test()
    public void updateTaxData() throws IOException, AWTException, InterruptedException {
        homePage.clickSettings();
        homePage.clickTax();
        taxPage.clickEdit();
        taxPage.updateData();
        Assert.assertTrue(taxPage.updatedData().size() > 0);
    }

}

