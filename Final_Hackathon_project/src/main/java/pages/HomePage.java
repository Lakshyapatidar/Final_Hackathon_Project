package pages;

import org.openqa.selenium.*;
import utils.WaitUtils;

public class HomePage {

    WebDriver driver;
    WaitUtils wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    By searchBox = By.xpath("//input[@placeholder='Search for anything']");
    By firstSuggestion = By.xpath("(//div[contains(@class,'suggestion')])[1]");
    By cookieBtn = By.xpath("//button[contains(text(),'Accept')]");

    public void handlePopup() {
        try {
            wait.clickWhenReady(cookieBtn);
        } catch (Exception e) {
            System.out.println("No popup");
        }
    }
    public void searchCourse(String course) {

        WebElement search = wait.waitForElement(searchBox);
        search.sendKeys(course);

        // wait a bit for UI stability
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        // press ENTER instead of clicking suggestion
        search.sendKeys(Keys.ENTER);
    }
}