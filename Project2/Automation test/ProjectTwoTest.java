package TestProjectTwo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectTwoTest {

    WebDriver driver = null;
    String descriptionFirst  = "August Salary";
    String descriptionSecond = "Dinner";
    String descriptionThird  = "travel";

    int amountFirst  = 1000;
    int amountSecond = -60;
    int amountThird  = -30;

    String categoryFirst  = "Salary";
    String categorySecond = "Bills";
    String categoryThird  = "Bills";


    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        //2-new object of webDriver
        driver = new EdgeDriver();
        //3-navigate to google website
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    public void checkInsightWithoutData() {

        driver.findElement(By.xpath("//button[text()='Show Insights']")).click();
        String expectedResult = "Total Expenses: $0.00";
        String actualResult = driver.findElement(By.xpath("//p[text()='Total Expenses: $']")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");
        driver.findElement(By.xpath("//button[text()='Exit']")).click();
        //Thread.sleep(2000);
    }

    @Test
    public void checkInsightWithData() {

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionFirst);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountFirst));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categoryFirst);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionSecond);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountSecond));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categorySecond);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionThird);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountThird));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categoryThird);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.xpath("//button[text()='Show Insights']")).click();

        String expectedResult = "Total Expenses: $90.00";
        String actualResult = driver.findElement(By.xpath("//p[text()='Total Expenses: $']")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult),"Test is true");
        driver.findElement(By.xpath("//button[text()='Exit']")).click();

    }

    @Test
    //view summery without data

    public void checkSummeryWithoutData()  {

        String expectedResultOne = "Total Income: $0.00";
        String actualResultOne = driver.findElement(By.xpath("//p[text()='Total Income: $']")).getText();

        String expectedResultTwo = "Total Expenses: $0.00";
        String actualResultTwo  = driver.findElement(By.xpath("//p[text()='Total Expenses: $']")).getText();

        String expectedResultThree = "Balance: $0.00";
        String actualResultThree = driver.findElement(By.xpath("//p[text()='Balance: $']")).getText();

        Assert.assertTrue(actualResultOne.contains(expectedResultOne),"Test is true");
        Assert.assertTrue(actualResultTwo.contains(expectedResultTwo),"Test is true");
        Assert.assertTrue(actualResultThree.contains(expectedResultThree),"Test is true");

        driver.findElement(By.xpath("//button[text()='Exit']")).click();
        //Thread.sleep(2000);
    }

    @Test
    public void checkSummeryWithData()  {

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionFirst);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountFirst));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categoryFirst);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionSecond);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountSecond));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categorySecond);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionThird);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountThird));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categoryThird);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        String expectedResultOne = "Total Income: $1000.00";
        String actualResultOne = driver.findElement(By.xpath("//p[text()='Total Income: $']")).getText();

        String expectedResultTwo = "Total Expenses: $90.00";
        String actualResultTwo  = driver.findElement(By.xpath("//p[text()='Total Expenses: $']")).getText();

        String expectedResultThree = "Balance: $910.00";
        String actualResultThree = driver.findElement(By.xpath("//p[text()='Balance: $']")).getText();

        Assert.assertTrue(actualResultOne.contains(expectedResultOne),"Test is true");
        Assert.assertTrue(actualResultTwo.contains(expectedResultTwo),"Test is true");
        Assert.assertTrue(actualResultThree.contains(expectedResultThree),"Test is true");

        driver.findElement(By.xpath("//button[text()='Exit']")).click();

    }

    @Test
    public void checkTransWithoutSort()  {

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionFirst);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountFirst));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categoryFirst);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionSecond);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountSecond));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categorySecond);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionThird);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountThird));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categoryThird);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.xpath("//button[text()='Show Transactions']")).click();

        String expectedResultOneOne = "Dinner";
        String actualResultOneOne = driver.findElement(By.xpath("//td[text()='Dinner']")).getText();
        String expectedResultOneTwo = "-60";
        String actualResultOneTwo = driver.findElement(By.xpath("//td[text()='-60']")).getText();
        String expectedResultOneThree = "Bills";
        String actualResultOneThree = driver.findElement(By.xpath("//td[text()='Bills']")).getText();


        String expectedResultTwoOne = "travel";
        String actualResultTwoOne  = driver.findElement(By.xpath("//td[text()='travel']")).getText();
        String expectedResultTwoTwo = "-30";
        String actualResultTwoTwo  = driver.findElement(By.xpath("//td[text()='-30']")).getText();
        String expectedResultTwoThree = "Bills";
        String actualResultTwoThree = driver.findElement(By.xpath("//td[text()='Bills']")).getText();



        String expectedResultThreeOne = "August";
        String actualResultThreeOne  = driver.findElement(By.xpath("//td[text()='August Salary']")).getText();
        String expectedResultThreeTwo = "1000";
        String actualResultThreeTwo = driver.findElement(By.xpath("//td[text()='1000']")).getText();
        String expectedResultThreeThree = "Salary";
        String actualResultThreeThree = driver.findElement(By.xpath("//td[text()='Salary']")).getText();

        Assert.assertTrue(actualResultOneOne.contains(expectedResultOneOne),"Test is true");
        Assert.assertTrue(actualResultOneTwo.contains(expectedResultOneTwo),"Test is true");
        Assert.assertTrue(actualResultOneThree.contains(expectedResultOneThree),"Test is true");

        Assert.assertTrue(actualResultTwoOne.contains(expectedResultTwoOne),"Test is true");
        Assert.assertTrue(actualResultTwoTwo.contains(expectedResultTwoTwo),"Test is true");
        Assert.assertTrue(actualResultTwoThree.contains(expectedResultTwoThree),"Test is true");

        Assert.assertTrue(actualResultThreeOne.contains(expectedResultThreeOne),"Test is true");
        Assert.assertTrue(actualResultThreeTwo.contains(expectedResultThreeTwo),"Test is true");
        Assert.assertTrue(actualResultThreeThree.contains(expectedResultThreeThree),"Test is true");


        driver.findElement(By.xpath("//button[text()='Exit']")).click();

    }

    @Test
    public void checkTransWithSort() {

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionFirst);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountFirst));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categoryFirst);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionSecond);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountSecond));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categorySecond);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("input[placeholder=\"Description\"]")).sendKeys(descriptionThird);
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(amountThird));
        driver.findElement(By.cssSelector("input[placeholder=\"Category\"]")).sendKeys(categoryThird);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        driver.findElement(By.xpath("//button[text()='Show Transactions']")).click();

        driver.findElement(By.xpath("//button[text()='Sort by Amount (']")).click();


        String expectedResultOneOne   = "August";
        String actualResultOneOne     = driver.findElement(By.xpath("//td[text()='August Salary']")).getText();
        String expectedResultOneTwo   = "1000";
        String actualResultOneTwo     = driver.findElement(By.xpath("//td[text()='1000']")).getText();
        String expectedResultOneThree = "Salary";
        String actualResultOneThree   = driver.findElement(By.xpath("//td[text()='Salary']")).getText();

        String expectedResultTwoOne   = "travel";
        String actualResultTwoOne     = driver.findElement(By.xpath("//td[text()='travel']")).getText();
        String expectedResultTwoTwo   = "-30";
        String actualResultTwoTwo     = driver.findElement(By.xpath("//td[text()='-30']")).getText();
        String expectedResultTwoThree = "Bills";
        String actualResultTwoThree   = driver.findElement(By.xpath("//td[text()='Bills']")).getText();

        String expectedResultThreeOne   = "Dinner";
        String actualResultThreeOne     = driver.findElement(By.xpath("//td[text()='Dinner']")).getText();
        String expectedResultThreeTwo   = "-60";
        String actualResultThreeTwo     = driver.findElement(By.xpath("//td[text()='-60']")).getText();
        String expectedResultThreeThree = "Bills";
        String actualResultThreeThree   = driver.findElement(By.xpath("//td[text()='Bills']")).getText();


        Assert.assertTrue(actualResultOneOne.contains(expectedResultOneOne),"Test is true");
        Assert.assertTrue(actualResultOneTwo.contains(expectedResultOneTwo),"Test is true");
        Assert.assertTrue(actualResultOneThree.contains(expectedResultOneThree),"Test is true");

        Assert.assertTrue(actualResultTwoOne.contains(expectedResultTwoOne),"Test is true");
        Assert.assertTrue(actualResultTwoTwo.contains(expectedResultTwoTwo),"Test is true");
        Assert.assertTrue(actualResultTwoThree.contains(expectedResultTwoThree),"Test is true");

        Assert.assertTrue(actualResultThreeOne.contains(expectedResultThreeOne),"Test is true");
        Assert.assertTrue(actualResultThreeTwo.contains(expectedResultThreeTwo),"Test is true");
        Assert.assertTrue(actualResultThreeThree.contains(expectedResultThreeThree),"Test is true");

        driver.findElement(By.xpath("//button[text()='Exit']")).click();

    }



    @AfterMethod
    public void closeBrowser()  {
        driver.quit();
    }

}
