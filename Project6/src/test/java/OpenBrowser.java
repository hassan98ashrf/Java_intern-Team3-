import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) throws InterruptedException {

        String chromePath =  System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";

        //1- bridge between test scripts and browser
        System.setProperty("webdriver.chrome.driver",chromePath);

        //2-new object of webdriver
        WebDriver driver = new ChromeDriver();

        //3-navigate to google website
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();


        //4- enter user and password
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        Thread.sleep(3000);

        //5- click login
        //driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
       // driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        //6- get information
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
