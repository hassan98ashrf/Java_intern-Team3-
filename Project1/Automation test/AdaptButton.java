package ProjectOne;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdaptButton {
    WebDriver driver;  //we cant use cause it's not the same so we make constractour

    public AdaptButton(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement statusMessageElement()
    {
        By statusMessage = By.id("status-message");
        return driver.findElement(statusMessage);
    }

    public WebElement statusElement()
    {
        By statusEle = By.id("status-btn");
        return driver.findElement(statusEle);
    }


    public WebElement endMessageElement()
    {
        By endMessage = By.id("end-btn");
        return driver.findElement(endMessage);
    }


    public WebElement feedMessageElement()
    {
        By feedMessage = By.id("feed-btn");
        return driver.findElement(feedMessage);
    }

    public WebElement playMessageElement()
    {
        By playMessage = By.id("play-btn");
        return driver.findElement(playMessage);
    }

    public WebElement gameMessageElement()
    {
        By gameMessage = By.id("game-status");
        return driver.findElement(gameMessage);
    }

    public WebElement adaptElement()
    {
        By adaptMessage = By.id("adopt-btn");
        return driver.findElement(adaptMessage);
    }

    public void adaptStep(String name)
    {
        adaptElement().click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(name);
        promptAlert.accept();
    }


}


