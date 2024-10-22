import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test1 {

    WebDriver driver = null;

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
        Thread.sleep(2000);
    }


    //hard assertion
    @Test
    public void validData()
    {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

        String expectedResult = "You logged into a secure area!";
        String actualResult = driver.findElement(By.id("flash")).getText();

        //first assertion
        Assert.assertEquals(actualResult.contains(expectedResult),true);
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");

        //second assertion
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://the-internet.herokuapp.com/secure"));
    }

    @Test
    public void invalidData()
    {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(",kk,kj,kj");
        driver.findElement(By.name("password")).sendKeys("Supe,jk,kj!");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

        String expectedResult = "Your username is valid!";
        String actualResult = driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult),"Error message : text is wrong");

    }



    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        String sucssesMSG =  driver.findElement(By.id("flash")).getText();
        String sucssesClass =  driver.findElement(By.id("flash")).getAttribute("class");
        String color =  driver.findElement(By.id("flash")).getCssValue("background-color");
        System.out.println(sucssesMSG);
        System.out.println(sucssesClass);
        System.out.println(color);


        Thread.sleep(2000);
        //7- close the program
        driver.quit();
    }


}


