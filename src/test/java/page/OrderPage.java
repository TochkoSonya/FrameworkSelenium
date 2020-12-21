package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(className="basket-item-actions-remove")
    List<WebElement> listOfDeleteButtons;

    @FindBy(className="basket-items-list-item-container")
    List<WebElement> listOfItems;


    public OrderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public OrderPage removeOneItem(int itemNumber){
        logger.info("Delete one of two items from order");
        listOfDeleteButtons.get(itemNumber).click();
        return this;
    }

    public OrderPage restourationItem(){
        logger.info("Restore item after delete in order");
       driver.findElement(By.cssSelector("div[class='basket-items-list-item-removed-block'] a"));
        return this;
    }

    public List<WebElement> getListOfItemsInOrder(){
        return listOfItems;
    }

}
