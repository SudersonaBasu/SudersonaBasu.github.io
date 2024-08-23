package Important;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverInit {

        private static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
               // driver = new ChromeDriver();
                // Set the system property for GeckoDriver
                System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

                // Specify the path to the Firefox binary
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");

                // Initialize FirefoxDriver with options
                WebDriver driver = new FirefoxDriver(options);


                // Maximize the browser window
                driver.manage().window().maximize();

                // Set implicit wait
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                // Launch the URL
                driver.get("https://www2.hm.com");
            }
            return driver;
        }

        public static void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }


}
