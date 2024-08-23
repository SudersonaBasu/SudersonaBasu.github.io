package Important;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
// import io.qameta.allure.testng.AllureTestNg;


@CucumberOptions(
        features = "src/test/resources/FeatureFiles",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests{



        @BeforeClass
        public void setUp() {
            DriverInit.getDriver();
        }

        @AfterClass
        public void tearDown() {
            DriverInit.quitDriver();
        }


}
