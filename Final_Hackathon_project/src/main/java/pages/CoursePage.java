package pages;

import org.openqa.selenium.*;
import utils.WaitUtils;

public class CoursePage {

    WebDriver driver;
    WaitUtils wait;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    By title = By.xpath("//h1");
    By rating = By.xpath("//span[contains(@class,'rating')]");
    By instructor = By.xpath("//a[contains(@href,'user')]");

    public boolean validateCourseDetails() {
        return wait.waitForElement(title).isDisplayed()
            && wait.waitForElement(rating).isDisplayed()
            && wait.waitForElement(instructor).isDisplayed();
    }
}