package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.WaitMethods;

public class HomePage extends AbstractPage{

    @FindBy(className ="search")
    private WebElement searchButton;

    @FindBy(name="q")
    private WebElement searchField;

public HomePage(WebDriver driver){
    super(driver);
    PageFactory.initElements(this.driver,this);
}

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        WaitMethods.waitForElementClickable(driver,5, searchButton);
        return this;
    }

    public CatalogPage searchForTerms(String searchQuery){
        searchButton.click();
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.ENTER);
        return new CatalogPage(driver);
    }

}

