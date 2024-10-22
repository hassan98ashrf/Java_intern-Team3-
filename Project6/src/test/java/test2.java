import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test2 {


    private static final Logger log = LoggerFactory.getLogger(test2.class);
    WebDriver driver = null;
    LoginPage login;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        String chromePath =  System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";

        //1- bridge between test scripts and browser
        System.setProperty("webdriver.chrome.driver",chromePath);

        //2-new object of webdriver
        driver = new ChromeDriver();

        //3-navigate to google website
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        login = new LoginPage(driver);

    }


    //sofrt assertion
    @Test
    public void validData()
    {
        SoftAssert soft = new SoftAssert();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        //driver.findElement(By.id("username")).clear();
        //driver.findElement(By.id("username")).sendKeys("tomsmith");
        //driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

        //usernameElement().clear();
        //usernameElement().sendKeys("tomsmith");
        //passwordElement().sendKeys("SuperSecretPassword!");
        //passwordElement().sendKeys(Keys.ENTER);


        //login.usernameElement(driver).clear();
        //login.usernameElement(driver).sendKeys("tomsmith");
        //login.passwordElement(driver).sendKeys("SuperSecretPassword!");
        //login.passwordElement(driver).sendKeys(Keys.ENTER);

        login.loginSteps("tomsmith","SuperSecretPassword!");

        String expectedResult = "You logged into a secure area!";
       // String actualResult = driver.findElement(By.id("flash")).getText();
        String actualResult = driver.findElement(login.flashBOM()).getText();

        //first assertion
        soft.assertEquals(actualResult.contains(expectedResult),true,"First Assertion A");
        soft.assertTrue(actualResult.contains(expectedResult),"First Assertion B");

        //second assertion
        soft.assertTrue(driver.findElement(login.URLBOM()).isDisplayed(),"second Assertion A");

        //third assertion
        soft.assertTrue(driver.getCurrentUrl().contains("https://the-internet.herokuapp.com/secure"),"Third Assertion A");

        //assert all
        soft.assertAll();

    }

    @Test
    public void invalidData()
    {
        SoftAssert soft = new SoftAssert();
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        //driver.findElement(By.id("username")).clear();
        //driver.findElement(By.id("username")).sendKeys(",kk,kj,kj");
        //driver.findElement(By.name("password")).sendKeys("Supe,jk,kj!");
        //driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        //login.usernameElement(driver).clear();
        //login.usernameElement(driver).sendKeys(",kk,kj,kj");
        //login.passwordElement(driver).sendKeys("Supe,jk,kj!");
        //login.passwordElement(driver).sendKeys(Keys.ENTER);
        login.loginSteps(",kk,kj,kj","Supe,jk,kj!");

        String expectedResult = "Your username is valid!";
       // String actualResult = driver.findElement(By.id("flash")).getText();
        String actualResult = driver.findElement(login.flashBOM()).getText();
        soft.assertFalse(actualResult.contains(expectedResult),"Error message : text is wrong");
        soft.assertAll();
    }



    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        String sucssesMSG =  driver.findElement(login.flashBOM()).getText();
        String sucssesClass =  driver.findElement(login.flashBOM()).getAttribute("class");
        String color =  driver.findElement(login.flashBOM()).getCssValue("background-color");
        System.out.println(sucssesMSG);
        System.out.println(sucssesClass);
        System.out.println(color);


        Thread.sleep(1000);
        //7- close the program
        driver.quit();
    }


}


