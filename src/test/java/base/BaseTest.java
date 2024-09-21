package base;

import com.gobus.pages.base.BasePage;
import com.gobus.pages.base.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.gobus.pages.base.BasePage.delay;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String GoBus_URL = "https://go-bus.com/?lang=en";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(GoBus_URL);
        basePage = new BasePage();
        basePage.setDriver(driver, 20);
        homePage = new HomePage();
    }

    @AfterClass
    public void tearDown() {
        delay(3000);
        driver.quit();
    }
}
