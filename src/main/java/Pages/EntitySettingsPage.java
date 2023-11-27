package Pages;

import Base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class EntitySettingsPage extends TestBase {

    public EntitySettingsPage () throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    @FindBy(id = "facebook")
    WebElement facebook;

    @FindBy(xpath = "/html/body/app-root/div/main/app-layout/div/div/div/div[2]/app-entitysetting/div[2]/div/div/div/div/div/div/form/div[5]/div/div/div/div/div/div/div/div/button")
    WebElement submit;

    public void updateData(String uname) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", facebook);
        Thread.sleep(1000);
        facebook.clear();
        facebook.sendKeys(uname);
    }

    public void clickSubmit() throws InterruptedException {
        //submit
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submit);
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
    }

    public void acceptAlert() throws InterruptedException {
        //alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public ArrayList<String> updatedData() throws InterruptedException {
        ArrayList<String> data = new ArrayList<>();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", facebook);
        Thread.sleep(1000);
        data.add(facebook.getAttribute("value"));
        return data;

    }
}


