package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class QuikrLogin {


    private AppiumDriver driver;

    @When("User is on Quikr app login Page")
    public void iLaunchQuikrApp() throws Throwable {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium version", "1.7.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel 2");
        capabilities.setCapability("platformVersion", "7.1");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("autoAcceptAlerts", true);
       // capabilities.setCapability(fullReset, true);
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/quikr-10-17.apk");
        capabilities.setCapability("automationName", "UiAutomator2");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("He provide user name")
    public void enterUserName() throws Throwable{

        driver.findElementByXPath("").sendKeys("abc@123");

    }

    @And("He provide password")
    public void enterPassword() throws Throwable{

        driver.findElementByXPath("").sendKeys("Test@123");
    }

    @And("click on login button")
    public void clickLogin() throws Throwable{

        driver.findElementByXPath("").click();

    }

    @Then("He should be able to login with valid user name and password")
    public void verifyLogin() throws Throwable{


    }
}
