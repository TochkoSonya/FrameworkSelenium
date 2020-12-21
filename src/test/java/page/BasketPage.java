package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utilits;
import wait.WaitMethods;

import java.util.List;

public class BasketPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

    WaitMethods wait=new WaitMethods();

    @FindBy(css="div[class='item clearfix']")
    List<WebElement> favoriteItemsList;

    @FindBy(css = "a[class='close simple']")
    WebElement deleteItemFromBasketButton;

    @FindBy(css="div[class='item clearfix'] div span")
    WebElement priceOfItem;

    @FindBy(id="allSum_FORMATED")
    WebElement totalSum;

    @FindBy(css = "div[class='bx_ordercart_order_pay_center'] a")
    WebElement orderItemsButton;


    public BasketPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getCountResultsInBasket(){
        return favoriteItemsList.size();
    }

    public BasketPage deleteItemFromBasket(){
       WaitMethods.waitForElementVisibility(driver,20,deleteItemFromBasketButton);
        deleteItemFromBasketButton.click();
        return this;
    }

    public List<WebElement> getBasket(){
        return favoriteItemsList;
    }

    public OrderPage orderItemsFromBasket(){
        WaitMethods.waitForElementClickable(driver,15,orderItemsButton);

        logger.info("Scrool the page to click on button and click");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",orderItemsButton);
        orderItemsButton.click();
        return new OrderPage(driver);
    }

    public boolean compareResultSumWithExpected(int numberOfItems){
       Utilits utils= new Utilits();
       if(numberOfItems==1){
           if (utils.PricesAreEqual(priceOfItem,totalSum))
           {
               return true;
           }
           else
               return false;
       }
       else if(numberOfItems==2){
           if (utils.PricesAreEqual(priceOfItem,priceOfItem, totalSum))
           {
               return true;
           }
           else
               return false;
       }
       return true;
    }


}
