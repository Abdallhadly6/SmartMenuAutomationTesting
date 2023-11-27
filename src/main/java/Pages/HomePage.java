package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends TestBase {

    public HomePage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/app-root/div/main/app-layout/div/app-admintopbar/div/div/div/nav/div/ul/li[2]/a")
    WebElement buttonLogOut;


    ////   settings
    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/button[2]")
    WebElement buttonSettings;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[1]")
    WebElement buttonAccount;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[2]")
    WebElement entityProfile;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[3]")
    WebElement entitySettings;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[4]")
    WebElement addBranch;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[5]")
    WebElement branches;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[6]")
    WebElement addEmployee;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[7]")
    WebElement tax;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[8]")
    WebElement taxGroup;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[9]")
    WebElement coupon;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[2]/a[13]")
    WebElement tag;


    ////   menu
    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/button[3]")
    WebElement buttonMenu;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[3]/a[1]")
    WebElement buttonCategories;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[3]/a[2]")
    WebElement buttonItems;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[3]/a[3]")
    WebElement buttonAttributes;

    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/div[3]/a[4]")
    WebElement buttonAttributeDetails;





    public boolean getLogOutLink() {
        List<WebElement> list = driver.findElements(By.xpath("/html/body/app-root/div/main/app-layout/div/app-admintopbar/div/div/div/nav/div/ul/li[2]/a"));
        boolean temp = false;
        if(list.size()>0){
            return true;
        }
        return temp;
    }

    public void clickLogOut(){
        //logout
        buttonLogOut.click();
    }


    public void clickSettings() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", buttonSettings);
        jse.executeScript("arguments[0].click()", buttonSettings);
    }

    public void clickAccount(){
        //account
        buttonAccount.click();
    }

    public void clickEntityProfile(){
        //hotel
        entityProfile.click();
    }

    public void clickEntitySettings(){
        //users
        entitySettings.click();
    }

    public void clickAddBranch(){
        //users
        addBranch.click();
    }

    public void clickBranches(){
        //users
        branches.click();
    }


    public void clickAddEmployee(){
        //users
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", addEmployee);
        jse.executeScript("arguments[0].click()", addEmployee);
    }

    public void clickTax(){
        //users
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", tax);
        jse.executeScript("arguments[0].click()", tax);
    }

    public void clickTaxGroup(){
        //users
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", taxGroup);
        jse.executeScript("arguments[0].click()", taxGroup);
    }

    public void clickCoupon(){
        //users
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", coupon);
        jse.executeScript("arguments[0].click()", coupon);
    }

    public void clickTag(){
        //users
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", tag);
        jse.executeScript("arguments[0].click()", tag);
    }


    public void clickMenu(){
        //menu
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", buttonMenu);
        jse.executeScript("arguments[0].click()", buttonMenu);
    }


    public void clickCategories(){
        //services
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", buttonCategories);
        jse.executeScript("arguments[0].click()", buttonCategories);

    }

    public void clickItems(){
        //services
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", buttonItems);
        jse.executeScript("arguments[0].click()", buttonItems);

    }

    public void clickAttributes(){
        //services
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", buttonAttributes);
        jse.executeScript("arguments[0].click()", buttonAttributes);

    }

    public void clickAttributeDetails(){
        //services
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", buttonAttributeDetails);
        jse.executeScript("arguments[0].click()", buttonAttributeDetails);

    }


    //*////////////////////////////
    @FindBy(xpath = "//*[@id=\"mySidebar\"]/div/button[2]")
    WebElement buttonSettingsv2;

    @FindBy(xpath = "/html/body/app-root/div/main/app-details/div/div[2]/form/div[2]/div/div/div[3]/button")
    WebElement add;

    @FindBy(xpath = "/html/body/app-root/div/main/app-menulayout/app-layout1/div[1]/div/div[4]/div/div/div[3]/button")
    WebElement send;


    public void createOrder(){
        driver.navigate().to("https://smfront.gtwit.net/MzA4/MTIzYWESMEQ/ZmFsc2USMEQ");
        List<String> data = new ArrayList<String>();
        data.add("//*[@id=\"cat-18287\"]/div");
        data.add("//*[@id=\"cat-18286\"]/div");
        data.add("//*[@id=\"cat-18285\"]/div");
        data.add("//*[@id=\"cat-18288\"]/div");
        data.add("//*[@id=\"cat-18289\"]/div");
        Random random = new Random();
        int index1 =  random.nextInt(4 - 0) + 0;
        WebElement item1 = driver.findElement(By.xpath(data.get(index1)));
        int index2 =  random.nextInt(4 - 0) + 0;
        WebElement item2 = driver.findElement(By.xpath(data.get(index2)));



    }




}
