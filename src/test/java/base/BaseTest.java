package base;

import com.gobus.pages.base.BasePage;
import com.gobus.pages.base.HomePage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import static com.gobus.pages.base.BasePage.delay;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String GoBus_URL = "https://go-bus.com/?lang=en";



    public WebDriver setDriverType(String driverType){
        return switch (driverType) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            case "firefox" -> new FirefoxDriver();
            case "safari" -> new SafariDriver();
            case "internet explorer" -> new InternetExplorerDriver();
            default -> throw new IllegalArgumentException("Invalid driver type: " + driverType);
        };
    }

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver
        driver = setDriverType("edge");
        driver.manage().window().maximize();

        // Navigate to the GoBus URL
        driver.get(GoBus_URL);

        // Set up page objects and pass the driver
        basePage = new BasePage();
        basePage.setDriver(driver, 1);
        homePage = new HomePage();
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) throws IOException {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    java.time.LocalDate.now() + ") " +
                    testResult.getName() + ".png");

            FileHandler.copy(source, destination);

            System.out.println("Screenshot Located At " + destination);
        }
    }


    @AfterMethod
    public void tearDown() {
       // delay(3000);
        driver.quit();
    }
}
