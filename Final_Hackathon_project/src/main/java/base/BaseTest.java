package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup(); // FIXED
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.udemy.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}