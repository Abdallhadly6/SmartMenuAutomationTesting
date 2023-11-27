package Pages;

import Base.TestBase;
import TestUtils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class TagPage extends TestBase {

    public TagPage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    @FindBy(id = "aname")
    WebElement aName;

    @FindBy(id = "ename")
    WebElement eName;

    @FindBy(xpath = "//*[@id=\"collapseExample\"]/div/div/form/div/div[3]/div/input")
    WebElement color;

    @FindBy(xpath = "//*[@id=\"collapseExample\"]/div/div/form/div/div[4]/div[1]/button")
    WebElement submit;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div/div/div/table/tbody/tr[3]/td[4]")
    WebElement edit;

    ArrayList<WebElement> list = new ArrayList<>();

    public void enterTagData(String arabicName , String EnglishName , String fColor) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(aName));
        Thread.sleep(1000);
        aName.clear();
        aName.sendKeys(arabicName);
        wait.until(ExpectedConditions.visibilityOf(eName));
        Thread.sleep(1000);
        eName.clear();
        eName.sendKeys(EnglishName);
        wait.until(ExpectedConditions.visibilityOf(color));
        color.clear();
        color.sendKeys(fColor);

    }

    public void updateData() throws IOException, InterruptedException {
        String temp =    "editTag" +  TestUtils.getCounter();
        TestUtils.updateCounter();
        eName.clear();
        eName.sendKeys(temp);
        clickSubmit();
        Thread.sleep(1000);
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

}


