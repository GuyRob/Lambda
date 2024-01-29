package io.guyrob.lambda.ProductPages;

import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SearchPage extends base {
    public String getSearch(){
        return driver.findElement(locate.SP_txt_Searched).getText();
    }

    public List<WebElement> getProducts() {
        try {
            return driver.findElements(locate.SP_list_Products);
        } catch (Exception e){
            System.out.println("ERROR: Failed to get products");
            allure_FailLog("ERROR: Failed to get products");
        }
        return null;
    }

    public String getProductName(WebElement product) {
        try {
            return product.getText();
        } catch (Exception e){
            System.out.println("ERROR: Failed to get product name");
            allure_FailLog("ERROR: Failed to get product name");
        }
        return null;
    }

    public String getProductDescription(int id) { // TODO fix when there are products (working on empty results)
        System.out.println(driver.findElements(locate.SP_txt_Products_disc).get(id).getText());
        return driver.findElements(locate.SP_txt_Products_disc).get(id).getText();
    }
}
