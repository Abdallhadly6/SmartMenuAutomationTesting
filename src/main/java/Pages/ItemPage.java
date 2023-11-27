package Pages;

import Base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class ItemPage extends TestBase {

    public ItemPage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    @FindBy(id = "categoryId")
    WebElement category;

    @FindBy(id = "aname0")
    WebElement aName;


    @FindBy(id = "ename0")
    WebElement eName;


    @FindBy(id = "price0")
    WebElement price;


    @FindBy(xpath = "//*[@id=\"collapseExample\"]/div/div/form/div[3]/div[1]/button")
    WebElement submit;

    @FindBy(xpath = "//*[tr[1]]//td[10]")
    WebElement edit;

    @FindBy(xpath = "//*[tr[1]]//td[11]")
    WebElement delete;

    @FindBy(xpath = "//*[tr[1]]//td[2]")
    WebElement nameForDeletedItem;

    @FindBy(xpath = "//*[tr[1]]//td[9]//*//*")
    WebElement status;

    @FindBy(xpath= "//*[tr[1]]//td[9]//*//*//*//*")
    WebElement checkIcon;

    String temp;

    public void enterItemData(String EnglishName) throws InterruptedException, AWTException {
        wait.until(ExpectedConditions.visibilityOf(category));
        Select select2 = new Select(category);
        select2.selectByVisibleText("arabicName");
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOf(aName));
        aName.clear();
        aName.sendKeys("اختبار");

        wait.until(ExpectedConditions.visibilityOf(eName));
        eName.clear();
        eName.sendKeys(EnglishName);

        wait.until(ExpectedConditions.visibilityOf(price));
        price.clear();
        price.sendKeys("50");
        Thread.sleep(1000);
        clickSubmit();
    }

    public void updateItem(String EnglishName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(category));
        Select select2 = new Select(category);
        select2.selectByVisibleText("arabicName");
        Thread.sleep(1000);
        clickEdit();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOf(eName));
        eName.clear();
        eName.sendKeys(EnglishName);
        clickSubmit();
    }

    public void deleteItem() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(category));
        Select select2 = new Select(category);
        select2.selectByVisibleText("arabicName");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(nameForDeletedItem));
        temp = nameForDeletedItem.getText();
        clickDelete();
        Thread.sleep(1000);
        acceptAlert();
        Thread.sleep(3000);
    }

    public String itemName(){
        return temp;
    }

    public void clickSubmit(){
        //submit
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click()", submit);
    }

    public void clickEdit() throws InterruptedException {
        //edit
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", edit);
        jse.executeScript("arguments[0].click()", edit);
    }

    public void clickDelete() throws InterruptedException {
        //edit
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", delete);
        jse.executeScript("arguments[0].click()", delete);
    }

    public void acceptAlert() throws InterruptedException {
        //alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void clickCategoryForItem() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(category));
        Select select2 = new Select(category);
        select2.selectByVisibleText("arabicName");
        Thread.sleep(1000);
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
