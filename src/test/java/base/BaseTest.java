package base;

import com.gobus.pages.base.BasePage;
import com.gobus.pages.base.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.gobus.pages.base.BasePage.delay;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String GoBus_URL = "https://go-bus.com/?lang=en";

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the GoBus URL
        driver.get(GoBus_URL);

        // Set up page objects and pass the driver
        basePage = new BasePage();
        basePage.setDriver(driver, 20);
        homePage = new HomePage();
    }



    @AfterMethod
    public void tearDown() {
        delay(3000);
        driver.quit();
    }
}
