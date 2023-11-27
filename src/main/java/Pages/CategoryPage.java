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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class CategoryPage extends TestBase {

    public CategoryPage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    @FindBy(id = "aname")
    WebElement aName;

    @FindBy(id = "ename")
    WebElement eName;

    @FindBy(xpath = "//*[@id=\"collapseExample\"]/div/div/form/div/div[3]/button")
    WebElement submit;


    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/tr[3]/td[4]")
    WebElement edit;

    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/tr[3]/td[5]")
    WebElement delete;

    @FindBy(xpath = "//*[@id=\"cdk-drop-list-0\"]/tr[3]/td[2]")
    WebElement nameForDeletedCategory;

    @FindBy(xpath = "//*[tr[1]]//*//*//*//*")
    WebElement status;

    @FindBy(xpath= "//*[td[3]]//*//*//*//*//*")
    WebElement checkIcon;

    String temp;

    public void enterCategoryData(String arabicName , String EnglishName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(aName));
        aName.clear();
        aName.sendKeys(arabicName);
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(eName));
        eName.clear();
        eName.sendKeys(EnglishName);

    }

    public void updateCategory(String arabicName , String EnglishName) throws InterruptedException {
        clickEdit();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(aName));
        aName.clear();
        aName.sendKeys(arabicName);
        wait.until(ExpectedConditions.visibilityOf(eName));
        eName.clear();
        eName.sendKeys(EnglishName);
        clickSubmit();
    }

    public void deleteCategory() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(nameForDeletedCategory));
        temp = nameForDeletedCategory.getText();
        clickDelete();
        Thread.sleep(1000);
        acceptAlert();
        Thread.sleep(2000);
    }

    public String categoryName(){
        return temp;
    }

    public void clickSubmit(){
        //submit
        submit.click();
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
