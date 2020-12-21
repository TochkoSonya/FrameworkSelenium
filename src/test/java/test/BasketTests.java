package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ItemPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTests extends CommonConditions{


    @Test(description = "Test number 1")
    public void CompareItemPriceWithTotalSumInBasket() {

        boolean expectedResult=new ItemPage(driver)
                .openPage()
                .chooseSize(44)
                .addToBasket()
                .goToBasket()
                .compareResultSumWithExpected(1);

        assertThat(expectedResult).isTrue();

    }

    @Test(description = "Test number 2")
    public void AddTheSameItemsWithTheSameSizeToBasket() {
        int expectedResult=new ItemPage(driver)
                .openPage()
                .chooseSize(42)
                .addToBasket()
                .stayOnItemPage("basket")
                .addToBasket()
                .goToBasket()
                .getCountResultsInBasket();

         assertThat(expectedResult).isEqualTo(1);
    }

    @Test(description = "Test number 3")
    public void DeleteItemFromBasket() {
        int expectedResult=new ItemPage(driver)
                .openPage()
                .chooseSize(44)
                .addToBasket()
                .goToBasket()
                .deleteItemFromBasket()
                .getCountResultsInBasket();

        assertThat(expectedResult).isEqualTo(0);
    }

    @Test(description = "Test number 4")
    public void AddTheSameItemsDifferentSizeToBasket() {
        List<WebElement> basket =new ItemPage(driver)
                .openPage()
                .chooseSize(44)
                .addToBasket()
                .stayOnItemPage("basket")
                .chooseSize(42)
                .addToBasket()
                .goToBasket()
                .getBasket();

        assertThat(basket).isNotEmpty().hasSize(2);
    }

    @Test(description="Test number 5")
    public void RestorationOfOneOfTwoItemsInOrder() {
        List<WebElement> orderList=new ItemPage(driver)
                .openPage()
                .chooseSize(42)
                .addToBasket()
                .stayOnItemPage("basket")
                .chooseSize(44)
                .addToBasket()
                .goToBasket()
                .orderItemsFromBasket()
                .removeOneItem(1)
                .restourationItem()
                .getListOfItemsInOrder();

        assertThat(orderList).isNotEmpty().hasSize(2);
    }

    @Test(description="Test number 8")
    public void CompareSumOfTwoItemsWithTotalInBasket() {
        boolean expectedResult=new ItemPage(driver)
                .openPage()
                .chooseSize(42)
                .addToBasket()
                .stayOnItemPage("basket")
                .chooseSize(44)
                .addToBasket()
                .goToBasket()
                .compareResultSumWithExpected(2);

        assertThat(expectedResult).isTrue();
    }
}
