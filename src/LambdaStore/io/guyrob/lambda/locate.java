/*
 * (c) guyrob.lambda
 */
package io.guyrob.lambda;

import org.openqa.selenium.By;

public class locate {
    /** HomePage */
    // top trending
    public static By HP_list_trnd_Categories = By.xpath("//div[@id='mz-category-wall74213250']//div[@role]");

    // collection
    public static By HP_list_coll_Categories = By.xpath("//div[@id='entry_213264']//li[@class='nav-item']");
    public static By HP_btn_coll_Next = By.xpath("//div[@id='entry_213264']//a[@class='mz-swiper-nav-next']");
    public static By HP_btn_coll_Prev = By.xpath("//div[@id='entry_213264']//a[@class='mz-swiper-nav-prev']"); // when not clickable: class='mz-swiper-nav-prev swiper-button-disabled'

    public static By HP_list_coll_Products = By.xpath("//div[@id='entry_213264']//div[@role]");
}
