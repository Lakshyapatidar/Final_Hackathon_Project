package pages;

import org.openqa.selenium.*;
import utils.WaitUtils;
import java.util.List;

public class ProductPage {

    WebDriver driver;
    WaitUtils wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    By courseCards = By.xpath("//a[contains(@href,'/course/')]");
    By filterRating = By.xpath("//label[contains(text(),'4.0')]");
    By firstCourse = By.xpath("(//div[contains(@class,'course-card')])[1]");

    public boolean isResultsDisplayed() {
        List<WebElement> list = driver.findElements(courseCards);
        return list.size() > 0;
    }
    public void applyFilter() {
        wait.clickWhenReady(filterRating);
    }

    public void openFirstCourse() {
        wait.clickWhenReady(firstCourse);
    }
}