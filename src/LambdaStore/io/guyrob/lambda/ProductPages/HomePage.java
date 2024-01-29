package io.guyrob.lambda.ProductPages;

import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
import org.openqa.selenium.By;
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

    // top products
    public void topp_Next() {
        clickElement(driver.findElement(locate.HP_btn_topp_Next));
        sleep(1000);
    }

    public void topp_compareByName(String name) {
        List<WebElement> products = driver.findElements(locate.HP_list_topp_Products);
        for (WebElement ele : products){
            if (ele.getText().contains(name)){

                // visable check
                    if (ele.isDisplayed()){
                        hoverElement(ele);
                        sleep(1000);
                        ele.findElement(By.xpath(".//button[@title='Compare this Product']")).click();
                        sleep(1000);
                    }
                }
            }
        }

    public boolean topp_compareAlert_isDisplayed() {
        try {
            return driver.findElement(locate.HP_txt_topp_Alert).isDisplayed();
        } catch (Exception e){
            System.out.println("ERROR: Compare alert not displayed,  error - " + e.getMessage());
            allure_FailLog("ERROR: Compare alert not displayed,  error - " + e.getMessage());
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


    public void coll_quickView(int i) {
        sleep(1000);
        List<WebElement> products = driver.findElements(By.xpath(locate.HP_list_coll_Products));
        WebElement selected = products.get(i-1);
        if(selected.isDisplayed()){
            hoverElement(selected);
            sleep(1000);
            driver.findElement(By.xpath(locate.HP_list_coll_Products+"["+i+"]"+"//button[@title='Quick view']")).click();
            sleep(3000);
        }
    }

    public void coll_quickViewExit(){
        try {
            waitVisibility(10, locate.HP_btn_coll_qv_Exit);
            driver.findElement(locate.HP_btn_coll_qv_Exit).click();
            sleep(1000);
        } catch (Exception e){
            System.out.println("ERROR: Exit quick view failed");
            allure_FailLog("ERROR: Exit quick view failed");
        }
    }


    // search
    public void search(String text) {
        driver.findElement(locate.HP_inp_Search).click();
        sleep(1000);
        driver.findElement(locate.HP_inp_Search).sendKeys(text);
        driver.findElement(locate.HP_btn_Search).click();
        sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



}
