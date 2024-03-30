import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.ProductPages.ProductPage;
import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class P3_blog extends base {

    HomePage homepage;
    ProductPage productPage;


    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        homepage = new HomePage();
        productPage = new ProductPage();

        driver.manage().window().maximize();
        driver.get(testdata.url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void P1_fromTheBlog(){
        String expectedCategory = "blog";

        allure_Log("Scrolling to blog section");
        scroll_Element(driver.findElement(locate.HP_list_blog_Categories));

        allure_Log("Selecting blog");
        boolean isIndexDisplay = homepage.blog_SelectIndex(1);

        screenShot("HomePage\\P3", "P1_fromTheBlog");
        allure_LogAttachment("TEST: Blog index displayed, and navigated to product category successfully", "HomePage\\P3", "P1_fromTheBlog");
        Assert.assertTrue(isIndexDisplay && productPage.getCategory().toLowerCase().contains(expectedCategory));
    }

    @Test
    public void P2_readMoreAndPost(){
        allure_Log("Scrolling to read more and click");
        productPage.blog_ReadMore();

        allure_Log("Leaving a comment");
        productPage.blog_writeComment("Guy" , "g@g.com", "GUY TEST " + randStr(20));

        screenShot("HomePage\\P3", "P2_readMoreAndPost");
        allure_LogAttachment("TEST: Read more button not appears, leaved a comment successfully", "HomePage\\P3", "P2_readMoreAndPost");
        Assert.assertTrue(driver.findElement(locate.PP_txt_blog_CommentApproval).isDisplayed(), "ERROR: Comment not submitted");
    }

}
