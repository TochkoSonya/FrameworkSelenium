package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.ItemPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



public class WishListTests extends CommonConditions{


    @Test(description = "Test number 6")
    public void AddTheSameItemsToWishList() {

        List<WebElement> wishList=new ItemPage(driver)
                .openPage()
                .chooseSize(44)
                .addToWishList()
                .stayOnItemPage("wishList")
                .addToWishList()
                .goToWishList("second")
                .getWishList();

        //Assert.assertEquals(expectedSearchResult,1);
        assertThat(wishList).isNotEmpty().hasSize(1);
    }

    @Test(description = "Test number 7")
    public void DeleteItemFromWishList() {
        List<WebElement> wishList=new ItemPage(driver)
                .openPage()
                .addToWishList()
                .goToWishList("first")
                .deleteItemFromWishList()
                .getWishList();

        assertThat(wishList).isEmpty();
    }


}
