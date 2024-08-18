package TestProjectOne;

import ProjectOne.AdaptButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProjectOneTest {

    WebDriver driver = null;
    String name = "LOLO";
    AdaptButton adapt;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        String chromePath =  System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";

        //1- bridge between test scripts and browser
        System.setProperty("webdriver.chrome.driver",chromePath);

        //2-new object of webdriver
        driver = new ChromeDriver();

        //3-navigate to google website
        driver.navigate().to("file:///C:/Users/hassa/OneDrive/%D8%B3%D8%B7%D8%AD%20%D8%A7%D9%84%D9%85%D9%83%D8%AA%D8%A8/Project_1/UI%20and%20Styling.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        adapt = new AdaptButton(driver);
        //login = new LoginPage(driver);

    }

    @Test
    //check adapt function
    public void checkAdapt() throws InterruptedException {

        adapt.adaptStep(name);
        String expectedResult = "You have adopted LOLO! Take care of your pet.";
        String actualResult = adapt.statusMessageElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");
        //Thread.sleep(2000);
        adapt.endMessageElement().click();

    }

    @Test
    //check feed pet till reach +90
    public void OverFeed() throws InterruptedException {

        adapt.adaptStep(name);

        for(int i =0 ;i<5 ; i++)
        {
            adapt.feedMessageElement().click();
        }
        String expectedResult = "LOLO is full and cannot eat more.";
        String actualResult = adapt.statusMessageElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");

        //Thread.sleep(2000);
        adapt.endMessageElement().click();
    }

    @Test
    //check feed pet before reach +90
    public void FeedBeforeOver() throws InterruptedException {

        adapt.adaptStep(name);

        for(int i =0 ;i<4 ; i++)
        {
            adapt.feedMessageElement().click();
        }
        String expectedResult = "You fed LOLO. Hunger level increased!";
        String actualResult = adapt.statusMessageElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");

        //Thread.sleep(2000);
        adapt.endMessageElement().click();
    }

    @Test
    //check feed pet tell happiness reach 0
    public void FeedTellSad() throws InterruptedException {

        adapt.adaptStep(name);

        for(int i =0 ;i<2 ; i++)
        {
            adapt.playMessageElement().click();
        }

        for(int i =0 ;i<8; i++)
        {
            adapt.feedMessageElement().click();
        }
        String expectedResult = "Your pet is in critical condition. The game is over.";
        String actualResult = adapt.statusMessageElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");

        //Thread.sleep(2000);
        adapt.endMessageElement().click();
    }
    @Test
    //check play with pet before reach +90
    public void playBeforeOver() throws InterruptedException {

        adapt.adaptStep(name);

        adapt.playMessageElement().click();

        String expectedResult = "You played with LOLO. Happiness level increased!";
        String actualResult = adapt.statusMessageElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");

       // Thread.sleep(2000);
        adapt.endMessageElement().click();
    }

    @Test
    //check play pet tell hunger reach 0
    public void playTellSad() throws InterruptedException {


        adapt.adaptStep(name);

        for(int i =0 ;i<4 ; i++)
        {
            adapt.playMessageElement().click();
        }

        String expectedResult = "Your pet is in critical condition. The game is over.";
        String actualResult = adapt.statusMessageElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");

        //Thread.sleep(2000);
        adapt.endMessageElement().click();
    }

    @Test
    //Check status of happines and hunger
    public void checkStatus() throws InterruptedException {

        adapt.adaptStep(name);

        for(int i =0 ;i<1 ; i++)
        {
            adapt.playMessageElement().click();

        }
        for(int i =0 ;i<3; i++)
        {
            adapt.feedMessageElement().click();

        }

        adapt.statusElement().click();

        String expectedResult = "LOLO's Status: Hunger - 60, Happiness - 30";
        String actualResult = adapt.gameMessageElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");

       // Thread.sleep(2000);
        adapt.endMessageElement().click();
    }

    @Test
    //check end
    public void checkEnd() throws InterruptedException {

        adapt.adaptStep(name);
        adapt.playMessageElement().click();
        adapt.feedMessageElement().click();
        adapt.endMessageElement().click();
        String expectedResult = "Game Over! Final status of LOLO: Hunger - 40, Happiness - 50";
        String actualResult = adapt.statusMessageElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");


    }



    @AfterTest
    public void closeBrowser() throws InterruptedException {
        
        //Thread.sleep(2000);
        //7- close the program
        driver.quit();
    }

}
