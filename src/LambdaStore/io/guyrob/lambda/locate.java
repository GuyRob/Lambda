/*
 * (c) guyrob.lambda
 */
package io.guyrob.lambda;

import org.openqa.selenium.By;

public class locate {
    /** HomePage */
    // menu (top bar)
    public static By HP_btn_ShopCategory = By.id("entry_217832");

    public static By HP_list_shop_Categories = By.xpath("//div[@data-id='217841']//li/a");


    // search
    public static By HP_inp_Search = By.xpath("//div[@id='main-header']//input[@name='search']");
    public static By HP_btn_Search = By.xpath("//div[@id='main-header']//div[@class='search-button']//button");
    // top trending
    public static By HP_list_trnd_Categories = By.xpath("//div[@id='mz-category-wall74213250']//div[@role]");

    // top products
    public static By HP_list_topp_Products = By.xpath("//div[@id='mz-product-tab-37213259-0']//div[@role]");
    public static By HP_btn_topp_Next = By.xpath("//div[@id='mz-product-tab-37213259-0']//a[@class='swiper-button-next']");

    public static By HP_txt_topp_Alert = By.xpath("//div[@role='alert']");

    // collection
    public static By HP_list_coll_Categories = By.xpath("//div[@id='entry_213264']//li[@class='nav-item']");
    public static By HP_btn_coll_Next = By.xpath("//div[@id='entry_213264']//a[@class='mz-swiper-nav-next']");
    public static By HP_btn_coll_Prev = By.xpath("//div[@id='entry_213264']//a[@class='mz-swiper-nav-prev']"); // when not clickable: class='mz-swiper-nav-prev swiper-button-disabled'

    public static String HP_list_coll_Products = "//div[@id='entry_213264']//div[@role]";

    public static By HP_btn_coll_qv_Exit = By.xpath("//div[@id='quick-view']//button[@aria-label='close']");

    // blogs section
    public static By HP_list_blog_Categories = By.xpath("//div[@id='mz-article-tab-73213272-0']//div[@role]");

    /** SearchPage */
    public static By SP_txt_SearchedTextResult = By.xpath("//div[@id='product-search']//h1");
    public static By SP_list_Products = By.xpath("//div[@data-view_id='grid']//div[@class='product-thumb']");
    public static By SP_txt_Products_disc = By.xpath("//div[@id='entry_212469']//p");

    public static By SP_txt_Title = By.xpath("//div[@data-id='212392']/h1");

    public static By SP_txt_totalProducts = By.xpath("//div[@class='col-sm-6 text-right']");


    // Filters
    public static By SP_btn_filter_PriceScrollMaxValue = By.xpath("//div[@id='mz-filter-panel-0-0']//span[2]");
//    public static By SP_inp_filter_PriceMaxValue = By.xpath("//div[@id='mz-filter-content-0']//input[@placeholder='Maximum Price']");
    public static By SP_list_filter_Manufacturer = By.xpath("//div[@id='mz-filter-panel-0-1']//label");




    /** ProductPage*/
    public static By PP_txt_ProductBreadcrumb = By.xpath("//ol[@class='breadcrumb']");

    // blog
    public static By PP_btn_blog_ReadMore = By.xpath("//div[@id='article-article']//a[@href='#']");
    public static By PP_inp_blog_cmd = By.id("input-comment");
    public static By PP_inp_blog_cmd_name = By.xpath("//form[@id='form-comment']//input[@name='name']");
    public static By PP_inp_blog_cmd_mail = By.xpath("//form[@id='form-comment']//input[@name='email']");
    public static By PP_btn_blog_cmd = By.id("button-comment");

    public static By PP_txt_blog_CommentApproval = By.xpath("//div[@class='alert alert-success alert-dismissible']");


}
