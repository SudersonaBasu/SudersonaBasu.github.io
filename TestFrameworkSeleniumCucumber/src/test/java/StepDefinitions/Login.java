package StepDefinitions;
import Important.CommonMethods;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

public class Login {
        private static WebDriver driver;
        private static CommonMethods commonMethods;

        @BeforeClass
        public static void setUp() {
                commonMethods = new CommonMethods(driver, 10); // 10 seconds wait time
        }

        @Test
        @Given("^Before you start shopping Cookie is visible$")
        public void CookiePopup() throws InterruptedException {

        try {
                WebElement popup= driver.findElement(By.xpath(LoginPage.popup));
                if (popup.isDisplayed()) {
                        commonMethods.assertElementIsDisplayed(By.xpath(LoginPage.popup));
                        System.out.println("The element is displayed.");
                }
        }

        catch(Exception e) {
                        System.out.println("The element is not displayed.");
                }

        }
        @Test
        @When("^User Clicks on Accept Cookie$")
        public void ClickAccept() {

                try {
                        WebElement acceptCookie= driver.findElement(By.xpath(LoginPage.acceptCookie));
                        if (acceptCookie.isDisplayed()) {
                                commonMethods.clickElement(By.xpath(LoginPage.acceptCookie));
                                System.out.println("Accept cookie is clicked.");
                        }
                }
                catch(Exception e) {
                        System.out.println("The element is not displayed.");
                }

        }
        @Test
        @Then("^Cookie pop-up disappears$")
        public void PopUpDisappears() {
                commonMethods.assertElementIsDisplayed(By.xpath(LoginPage.logo));
        }

}
