package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPage extends AbstractPage{

    @FindBy(tagName = "img")
    List<WebElement> imageLinks;

    public CatalogPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ItemPage selectItem(){
        imageLinks.get(3).click();
        return new ItemPage(driver);
    }

}
