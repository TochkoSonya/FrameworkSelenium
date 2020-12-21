package page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wait.WaitMethods;

import java.util.List;
import java.util.NoSuchElementException;

public class ItemPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[class='chosen-single chosen-default'] span")
    private WebElement sizeListButton;

    @FindBy(css = "a[class='chosen-single'] span")
    private WebElement sizeListButton2;

    @FindBy(css="ul[class='chosen-results'] li")
    private List<WebElement> listOfElements;

    @FindBy(css="button[class='full black bttn tocart']")
    private WebElement addToBasketButton;

    @FindBy(css="a[class='black bttn']")
    private WebElement moveToBasketButton;

    @FindBy(css="button[class='gray bttn towishlist']")
    private WebElement addToWishListButton;

    @FindBy(css="div[class='add_to_wishlist-success modal-product visible'] button")
    private WebElement stayOnProductPageButton;

    @FindBy(css="div[class='add_to_basket-success modal-product visible'] button")
    private WebElement stayOnItemPageFromBasketButton;


    @FindBy(css ="div[class='add_to_wishlist-error modal-product visible'] a")
    private WebElement goToWishListButtonError;

    @FindBy(css ="div[class='add_to_wishlist-success modal-product visible'] a")
    private WebElement goToWishListButtonSuccess;


    public ItemPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ItemPage openPage(){
        driver.get(PRODACTPAGE_URL);
        return this;
    }

    public ItemPage chooseSize(int size){
        try {
            logger.info("Choose size of item");
            sizeListButton.click();
            WaitMethods.waitForElementClickable(driver,20,listOfElements.get(1));
            if (size == 42)
                listOfElements.get(0).click();
            else
                listOfElements.get(1).click();
            return this;
        }
        catch(ElementNotInteractableException e)
        {
            sizeListButton2.click();
            WaitMethods.waitForElementClickable(driver,20,listOfElements.get(1));
            if (size == 42)
                listOfElements.get(0).click();
            else
                listOfElements.get(1).click();
            return this;
        }

    }

    public ItemPage addToBasket(){
        addToBasketButton.click();
        WaitMethods.waitForElementClickable(driver,15,moveToBasketButton);
        return this;
    }

    public BasketPage goToBasket(){
        moveToBasketButton.click();
        return new BasketPage(driver);
    }
    public ItemPage addToWishList(){
        WaitMethods.waitForElementsLocatedBy(driver,20,By.cssSelector("button[class='gray bttn towishlist']"));
        addToWishListButton.click();
        return this;
    }

    public ItemPage stayOnItemPage(String type){
        if(type=="basket")
        {
            WaitMethods.waitForElementsLocatedBy(driver,20,By.cssSelector("div[class='add_to_basket-success modal-product visible'] button"));
             stayOnItemPageFromBasketButton.click();
        }
        else if(type=="wishList")
        {
            WaitMethods.waitForElementsLocatedBy(driver,20,By.cssSelector("div[class='add_to_wishlist-success modal-product visible'] button"));
               stayOnProductPageButton.click();
        }
        return this;
    }
    public WishListPage goToWishList(String type){
     if(type=="first"){
            goToWishListButtonSuccess.click();
        }
        else if(type=="second"){
            goToWishListButtonError.click();
        }
        return new WishListPage(driver);
    }

}
