/*
 * (c) guyrob.lambda
 */
package io.guyrob.lambda;

import org.openqa.selenium.By;

public class locate {
    /** HomePage */
    // top trending
    public static By HP_list_trnd_Categories = By.xpath("//div[@id='mz-category-wall74213250']//div[@role]");

    // top products
    public static By HP_list_topp_Products = By.xpath("//div[@id='mz-product-tab-37213259-0']//div[@role]");
    public static By HP_btn_topp_Next = By.xpath("//div[@id='mz-product-tab-37213259-0']//a[@class='swiper-button-next']");




    // collection
    public static By HP_list_coll_Categories = By.xpath("//div[@id='entry_213264']//li[@class='nav-item']");
    public static By HP_btn_coll_Next = By.xpath("//div[@id='entry_213264']//a[@class='mz-swiper-nav-next']");
    public static By HP_btn_coll_Prev = By.xpath("//div[@id='entry_213264']//a[@class='mz-swiper-nav-prev']"); // when not clickable: class='mz-swiper-nav-prev swiper-button-disabled'

    public static String HP_list_coll_Products = "//div[@id='entry_213264']//div[@role]";

    public static By HP_btn_coll_qv_Exit = By.xpath("//div[@id='quick-view']//button[@aria-label='close']");

}
