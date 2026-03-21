package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CourseSearchTest extends BaseTest {

    @Test
    public void verifyCourseSearchFlow() {

        HomePage home = new HomePage(driver);
        ProductPage search = new ProductPage(driver);
        CoursePage course = new CoursePage(driver);

        home.handlePopup();
        home.searchCourse("Python");

        Assert.assertTrue(search.isResultsDisplayed(), "Results not displayed");

        search.applyFilter();
        search.openFirstCourse();

        Assert.assertTrue(course.validateCourseDetails(), "Course details missing");
    }
}