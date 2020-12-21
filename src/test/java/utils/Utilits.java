package utils;

import org.openqa.selenium.WebElement;

public class Utilits {

    public boolean PricesAreEqual(WebElement itemPrice, WebElement totalPrice){
        String str=itemPrice.toString().substring(0,3);
        String str2=totalPrice.toString().substring(0,3);
        return str.equals(str2);
    }

    public boolean PricesAreEqual(WebElement itemPrice, WebElement itemPrice2, WebElement totalPrice){
        String str=itemPrice.toString().substring(0,3);
        String str2=totalPrice.toString().substring(0,3);
        String str3=itemPrice2.toString().substring(0,3);

        return  Integer.getInteger(str)+Integer.getInteger(str3)==Integer.getInteger(str2);
    }
}
