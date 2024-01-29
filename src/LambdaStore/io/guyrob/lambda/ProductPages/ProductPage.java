package io.guyrob.lambda.ProductPages;

import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;

public class ProductPage extends base {

    public String getCategory(){
        return driver.findElement(locate.PP_txt_category).getText();
    }


    // blog
    public void blog_ReadMore() {
        scroll_Element(driver.findElement(locate.PP_btn_blog_ReadMore));
        sleep(1000);
        driver.findElement(locate.PP_btn_blog_ReadMore).click();
    }

    public void blog_writeComment(String name, String mail, String comment) {
        scroll_Element(driver.findElement(locate.PP_inp_blog_cmd));
        sleep(1000);

        driver.findElement(locate.PP_inp_blog_cmd_name).click();
        driver.findElement(locate.PP_inp_blog_cmd_name).sendKeys(name);
        sleep(1000);

        driver.findElement(locate.PP_inp_blog_cmd_mail).click();
        driver.findElement(locate.PP_inp_blog_cmd_mail).sendKeys(mail);
        sleep(1000);

        driver.findElement(locate.PP_inp_blog_cmd).click();
        driver.findElement(locate.PP_inp_blog_cmd).sendKeys(comment);
        driver.findElement(locate.PP_btn_blog_cmd).click();
        sleep(3000);

    }
}
