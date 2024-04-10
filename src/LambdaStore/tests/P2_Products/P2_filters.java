
import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.ProductPages.SearchPage;
import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P2_filters extends base {
    HomePage homepage;
    SearchPage searchPage;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        homepage = new HomePage();
        searchPage = new SearchPage();

        driver.manage().window().maximize();
        driver.get(testdata.url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        allure_Log("Select category by index " + 6);
        homepage.shopCategory_index(6);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void P1_price(){
        int maxPricePercentage = 10;
        int initalResults = searchPage.getTotalProducts();

        allure_Log("Filter by max price of " + maxPricePercentage + "%");
        WebElement filterMaxPrice = driver.findElement(locate.SP_btn_filter_PriceScrollMaxValue);
        searchPage.filter_scrollToExactValue(filterMaxPrice, maxPricePercentage);

        screenShot("Products\\P2", "P1_price");
        allure_LogAttachment("TEST: Filtering max price successfully", "Products\\P2", "P1_price");
        Assert.assertTrue(initalResults > searchPage.getTotalProducts(), "ERROR: not filtered by price");
    }

    @Test
    public void P2_manufacturer(){

    }

    @Test
    public void P3_color(){

    }

    @Test
    public void P4_availability(){

    }
}
