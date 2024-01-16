package io.guyrob.lambda.ProductPages;

import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends base {


    // trending
    public boolean trnd_SelectIndex(int i) {
        sleep(1000);
        List<WebElement> categories = driver.findElements(locate.HP_list_trnd_Categories);
        if(categories.get(i-1).isDisplayed()) {
            categories.get(i - 1).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return true;
        } else {
            return false;
        }
    }

    // collection
    public boolean coll_SelectCategory(String categroyName) {
        sleep(1000);
        List<WebElement> categories = driver.findElements(locate.HP_list_coll_Categories);
        for (WebElement ele : categories){
            if (ele.getText().equals(categroyName)){
                ele.click();
                return true;
            }
        }
        return false;
    }

    public void coll_Next() {
        clickElement(driver.findElement(locate.HP_btn_coll_Next));
        sleep(1000);
    }

    public boolean coll_PrevIsDisaplyed() {
        return driver.findElement(locate.HP_btn_coll_Prev).isDisplayed();
    }



}
