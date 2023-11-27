package Pages;

import Base.TestBase;
import TestUtils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class CouponPage extends TestBase {

    public CouponPage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    @FindBy(id = "code")
    WebElement code;

    @FindBy(xpath = "//*[@id=\"type\"]")
    WebElement type;

    @FindBy(id = "amount")
    WebElement amount;


    @FindBy(xpath = "//*[@id=\"startDate\"]")
    WebElement startDate;

    @FindBy(xpath = "//*[@id=\"owl-dt-picker-0\"]/div[2]/div/button[2]/span")
    WebElement setStartDate;

    @FindBy(id = "maxUsed")
    WebElement maxUsed;
    @FindBy(xpath = "//*[@id=\"collapseExample\"]/div/div/form/div/div[7]/button")
    WebElement submit;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div/div/div/table/tbody/tr[1]/td[9]")
    WebElement edit;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div/div/div/table/tbody/tr[1]/td[8]/span/button")
    WebElement status;

    @FindBy(xpath= "//*[td[7]]//*//*//*//*//*")
    WebElement checkIcon;


    //



    ArrayList<WebElement> list = new ArrayList<>();

    public void enterCouponData(String fcode , String famount , String fmaxused) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(code));
        Thread.sleep(1000);
        code.clear();
        code.sendKeys(fcode);
        wait.until(ExpectedConditions.visibilityOf(type));
        Select select = new Select(type);
        select.selectByVisibleText("ثابت");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(amount));
        amount.clear();
        amount.sendKeys(famount);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        startDate.click();
        Thread.sleep(500);
        setStartDate.click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(maxUsed));
        maxUsed.clear();
        maxUsed.sendKeys(fmaxused);
        clickSubmit();
    }

    public void updateData() throws IOException, InterruptedException {
        String temp =    "editCode" +  TestUtils.getCounter();
        TestUtils.updateCounter();
        code.clear();
        code.sendKeys(temp);
        clickSubmit();
        driver.navigate().refresh();
        Thread.sleep(1000);
        list = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[contains(text(),'" + temp + "')]"));
    }

    public ArrayList<WebElement> updatedData() {
        return list;
    }


    public void clickSubmit(){
        //submit
        submit.click();
    }

    public void clickEdit(){
        //edit
        edit.click();
    }

    public void clickChange()  {
        //status
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", status);
        jse.executeScript("arguments[0].click()", status);

    }

    public String getStatus(){
        //status
        return checkIcon.getAttribute("data-icon");
    }

}
