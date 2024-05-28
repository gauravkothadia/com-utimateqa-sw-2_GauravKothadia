package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */
public class LoginTest extends BaseTest {
    @Before
    public void browserSetup() {
        openBrowser("https://courses.ultimateqa.com/");
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // click on the ‘Sign In’ link
        driver.findElement(By.partialLinkText("Sign In")).click();
        // Verify the text ‘Welcome Back!’
        String expectedHeading = "Welcome Back!";
        String actualHeading = driver.findElement(By.cssSelector("div.sign-in__wrapper h2.page__heading")).getText().trim();
        Assert.assertEquals(expectedHeading,actualHeading);

    }

    @Test
    public void verifyTheErrorMessage() {
        // click on the ‘Sign In’ link
        driver.findElement(By.partialLinkText("Sign In")).click();
        // Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("halxkshiuepowkd@abc.com");
        // Enter invalid password
        driver.findElement(By.name("user[password]")).sendKeys("InvalidPwd");
        // Click on Login button
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        // Verify the error message ‘Invalid email or password.’
        String expectedErrorText = "Invalid email or password.";
        String actualErrorText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals(expectedErrorText,actualErrorText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
