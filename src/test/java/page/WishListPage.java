package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.WaitMethods;

import java.util.List;

public class WishListPage extends AbstractPage {

    @FindBy(css="div[class='item clearfix']")
    private List<WebElement> itemsInWishList;

    @FindBy(css = "span[class='close simple']")
    WebElement deleteItemFromWishListButton;

    public WishListPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getNumberItemsInWishList(){
        WaitMethods.waitForElementVisibility(driver,5,itemsInWishList.get(0));
        return itemsInWishList.size();
    }

    public WishListPage deleteItemFromWishList(){
        WaitMethods.waitForElementVisibility(driver,10,deleteItemFromWishListButton);
        deleteItemFromWishListButton.click();
        return this;
    }

    public List<WebElement> getWishList(){
        return itemsInWishList;
    }
}
