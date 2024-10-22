import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    WebDriver driver;  //we cant use cause it's not the same so we make constractour

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement usernameElement()
    {
        By username = By.id("username");
        WebElement usernameEle = driver.findElement(username);

        return usernameEle;
    }

    public WebElement passwordElement()
    {
        By password= By.name("password");
        WebElement passwordElement = driver.findElement(password);

        return passwordElement;
    }

    public By flashBOM()
    {
        return By.id("flash");
    }

    public By URLBOM()
    {
        return By.cssSelector("a[href=\"/logout\"]");
    }

    public void loginSteps( String username , String password)
    {
        usernameElement().clear();
        usernameElement().sendKeys(username);
        passwordElement().sendKeys(password);
        passwordElement().sendKeys(Keys.ENTER);
    }

}
