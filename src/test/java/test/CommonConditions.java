package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver= DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }

}
