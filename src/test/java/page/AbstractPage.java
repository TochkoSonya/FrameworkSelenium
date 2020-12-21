package page;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected static final String HOMEPAGE_URL="https://lakbishop.by/";
    protected static final String PRODACTPAGE_URL="http://lakbishop.by/women-catalog/plate_zhenskoe_20s_52047/";

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver)  {

        this.driver = driver;
    }

}
