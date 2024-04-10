package io.guyrob.lambda.ProductPages;

import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class SearchPage extends base {
    public String getSearch(){
        return driver.findElement(locate.SP_txt_SearchedTextResult).getText();
    }

    public String getTitle(){
        return driver.findElement(locate.SP_txt_Title).getText();
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

    /** Filters */
    public void filter_scrollToExactValue(WebElement element, int percentage) {
        scroll_Element(element);
        actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.left = arguments[1] + '%';", element, percentage);
        actions.release(element).build().perform();
        sleep(3000);
    }

    public int getTotalProducts() {
        String totalResults = driver.findElement(locate.SP_txt_totalProducts).getText();
    // Find the starting index of the total count
        int startIndex = totalResults.lastIndexOf("of") + 3;
    // Find the ending index of the total count (assuming no digits after)
        int endIndex = totalResults.indexOf(" ", startIndex);
        endIndex = endIndex == -1 ? totalResults.length() : endIndex;  // Handle no space after number
    // Extract the total count
        int total = Integer.parseInt(totalResults.substring(startIndex, endIndex));

        return total;
    }
}
