package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_RegistrationTest {
    WebDriver driver;
    @BeforeClass
    public void initSetup(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "LoginData")
    public Object [][] data(){
        Object [][] data =new Object[2][6];

        //Set1
        data [0][0]="Tania";
        data [0][1]="Alam";
        data [0][2]="mail@mail.com\n";
        data [0][3]="01531111111";
        data [0][4]="123456";
        data [0][5]="123456";
        //Set=2
        data [1][0]="qqqq";
        data [1][1]="ertt";
        data [1][2]="mail2@gmail.com";
        data [1][3]="017452225572";
        data [1][4]="145222222";
        data [1][5]="145222222";

        return data;
    }

    @Test(dataProvider = "LoginData")
    public void TC_InValid(String DP_FirstName,String DP_LastName,String DP_Email,String DP_Telephone,String DP_Pass,String DP_ConPass) throws InterruptedException {
        WebElement Firstname= driver.findElement(By.name("firstname"));
        Firstname.clear();
        Firstname.sendKeys(DP_FirstName);
        Thread.sleep(3000);
        WebElement Lastname= driver.findElement(By.name("lastname"));
        Lastname.clear();
        Lastname.sendKeys(DP_LastName);
        Thread.sleep(3000);

        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys(DP_Email);
        Thread.sleep(3000);
        WebElement Telephone=driver.findElement(By.name("telephone"));
        Telephone.clear();
        Telephone.sendKeys(DP_Telephone);
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(DP_Pass);
        Thread.sleep(3000);
        WebElement Password_Confirm=driver.findElement(By.name("password confirm"));
        Password_Confirm.clear();
        Password_Confirm.sendKeys(DP_ConPass);
        Thread.sleep(3000);
        WebElement Yes_NoBtn= driver.findElement(By.name("yes/no"));
        Yes_NoBtn.click();
        WebElement ContinueBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        ContinueBtn.click();

        System.out.println("TC_InValid Executed");
    }
}
