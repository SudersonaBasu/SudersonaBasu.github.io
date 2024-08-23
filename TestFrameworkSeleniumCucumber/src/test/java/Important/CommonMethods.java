package Important;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods {


        private WebDriver driver;
        private WebDriverWait wait;

        public CommonMethods(WebDriver driver, int waitTime) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, waitTime);
        }

        // Explicit Waits

        public WebElement waitForElementToBeClickable(By locator) {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }

        public WebElement waitForElementToBeVisible(By locator) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public WebElement waitForElementToBePresent(By locator) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

        public boolean waitForTextToBePresentInElement(By locator, String text) {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        }

        // Keyboard Actions

        public void sendKeysToElement(By locator, String keys) {
            WebElement element = driver.findElement(locator);
            element.sendKeys(keys);
        }

        public void pressEnter() {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ENTER).perform();
        }

        // Mouse Actions

        public void clickElement(By locator) {
            WebElement element = driver.findElement(locator);
            element.click();
        }

        public void hoverOverElement(By locator) {
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(locator);
            actions.moveToElement(element).perform();
        }

        public void rightClickElement(By locator) {
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(locator);
            actions.contextClick(element).perform();
        }

        public void dragAndDropElement(By sourceLocator, By targetLocator) {
            Actions actions = new Actions(driver);
            WebElement source = driver.findElement(sourceLocator);
            WebElement target = driver.findElement(targetLocator);
            actions.dragAndDrop(source, target).perform();
        }

        // Scrolling

        public void scrollToElement(By locator) {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }

        public void scrollByPixel(int x, int y) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        }

        // Handling Alerts

        public void acceptAlert() {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }

        public void dismissAlert() {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }

        public void sendKeysToAlert(String text) {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            alert.accept();
        }

        // Frame Handling

        public void switchToFrameByIndex(int index) {
            driver.switchTo().frame(index);
        }

        public void switchToFrameById(String id) {
            driver.switchTo().frame(id);
        }

        public void switchToFrameByName(String name) {
            driver.switchTo().frame(name);
        }

        public void switchToDefaultContent() {
            driver.switchTo().defaultContent();
        }

        // Assertions

        public void assertElementText(By locator, String expectedText) {
            WebElement element = driver.findElement(locator);
            String actualText = element.getText();
            Assert.assertEquals(actualText, expectedText, "Text does not match.");
        }

        public void assertElementIsDisplayed(By locator) {
            WebElement element = driver.findElement(locator);
            Assert.assertTrue(element.isDisplayed(), "Element is not displayed.");
        }

        public void assertElementIsNotDisplayed(By locator) {
            WebElement element = driver.findElement(locator);
            Assert.assertFalse(element.isDisplayed(), "Element is displayed but should not be.");
        }

        public void assertTitleContains(String expectedTitlePart) {
            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(expectedTitlePart), "Title does not contain expected text.");
        }

        public void assertCurrentUrl(String expectedUrl) {
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "URL does not match.");
        }


}
