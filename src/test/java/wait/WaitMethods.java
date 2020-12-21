package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitMethods {

    public static WebElement waitForElementClickable(WebDriver driver, long time, WebElement webElem) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(webElem));
    }

    public static WebElement waitForElementVisibility(WebDriver driver, long time, WebElement webElem) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOf(webElem));
    }

    public static List<WebElement> waitForElementsLocatedBy(WebDriver driver, long time, By by) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}
