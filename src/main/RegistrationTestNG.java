package com.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/*
    Using BeforeClass and AfterClass
    @BeforeClass execute only one time for all @Test method
    @AfterClass execute only one time after all @Test method
     */

    public class RegistrationTestNG {
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

        @Test(priority = 1,description = "Registration.")
        public void TC_Valid_001() throws InterruptedException {
            WebElement Firstname= driver.findElement(By.name("firstname"));
            Firstname.clear();
            Firstname.sendKeys("Tania");
            Thread.sleep(3000);
            WebElement Lastname= driver.findElement(By.name("lastname"));
            Lastname.clear();
            Lastname.sendKeys("Alam");
            Thread.sleep(3000);
            WebElement Email=driver.findElement(By.name("email"));
            Email.clear();
            Email.sendKeys("user101@gmail.com");
            Thread.sleep(3000);
            WebElement Telephone=driver.findElement(By.name("telephone"));
            Telephone.clear();
            Telephone.sendKeys("01531111111");
            Thread.sleep(3000);
            WebElement Password=driver.findElement(By.name("password"));
            Password.clear();
            Password.sendKeys("123456");
            Thread.sleep(3000);
            WebElement Password_Confirm=driver.findElement(By.name("password confirm"));
            Password_Confirm.clear();
            Password_Confirm.sendKeys("123456");
            Thread.sleep(3000);
            WebElement Yes_NoBtn= driver.findElement(By.name("yes/no"));
            Yes_NoBtn.click();
            WebElement ContinueBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
            ContinueBtn.click();

            System.out.println("TC_Valid_Registration_001 Executed");
        }

        @Test(priority = 2,description = "Valid_Registration")
        public void TC_InValid_002() throws InterruptedException {
            WebElement Firstname= driver.findElement(By.name("firstname"));
            Firstname.clear();
            Firstname.sendKeys("Tania");
            Thread.sleep(3000);
            WebElement Lastname= driver.findElement(By.name("lastname"));
            Lastname.clear();
            Lastname.sendKeys("Alam");
            Thread.sleep(3000);
            WebElement Email=driver.findElement(By.name("email"));
            Email.clear();
            Email.sendKeys("user101@gmail.com");
            Thread.sleep(3000);
            WebElement Telephone=driver.findElement(By.name("telephone"));
            Telephone.clear();
            Telephone.sendKeys("01531111111");
            Thread.sleep(3000);
            WebElement Password=driver.findElement(By.name("password"));
            Password.clear();
            Password.sendKeys("123456");
            Thread.sleep(3000);
            WebElement Password_Confirm=driver.findElement(By.name("password confirm"));
            Password_Confirm.clear();
            Password_Confirm.sendKeys("123456");
            Thread.sleep(3000);
            WebElement Yes_NoBtn= driver.findElement(By.name("yes/no"));
            Yes_NoBtn.click();
            WebElement ContinueBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
            ContinueBtn.click();
            System.out.println("TC_Valid_Registration_002 Executed");
        }


    }



