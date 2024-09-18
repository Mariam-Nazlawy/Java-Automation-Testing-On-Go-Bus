package part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoBusTesting {

    WebDriver driver;


    public String driverType = "chrome";


    @BeforeClass
    public void setUp(){
        if(driverType.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.get("https://go-bus.com/?lang=en");
        driver.manage().window().maximize();
    }
    @Test
    public void loginTestToGoBus(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // login page
        driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
        // choose login with email
        driver.findElement(By.xpath("//button[@class='btn btn-email']")).click();

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("maryamnzlawy@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("gobus-secret");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[1]/header/div[2]/div/div[3]/div[1]/div[1]/h4")));
        String dropDownText = dropDown.getText();


        Assert.assertEquals(dropDownText, "My Account", "My Account is expected to appear");

    }


    @AfterClass
    public void tearDown(){
        //driver.quit();
    }



}
