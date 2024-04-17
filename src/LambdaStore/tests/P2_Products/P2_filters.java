
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
        searchPage.filter_price_scrollToExactValue(filterMaxPrice, maxPricePercentage);

        screenShot("Products\\P2", "P1_price");
        allure_LogAttachment("TEST: Filtering max price", "Products\\P2", "P1_price");
        Assert.assertTrue(initalResults > searchPage.getTotalProducts(), "ERROR: not filtered by price");
    }

    @Test
    public void P2_manufacturer(){
        String selectedManufacturer = "Canon";
        int initalResults = searchPage.getTotalProducts();

        allure_Log("Filter by manufacturer " + selectedManufacturer);
        searchPage.filter_manu_ByName(selectedManufacturer);

        screenShot("Products\\P2", "P2_manufacturer");
        allure_LogAttachment("TEST: Filtering manufacturer", "Products\\P2", "P2_manufacturer");
        Assert.assertTrue(initalResults > searchPage.getTotalProducts(), "ERROR: not filtered by manufacturer");
    }

    @Test
    public void P3_color(){
        String selectedColor = "Red";
        int initalResults = searchPage.getTotalProducts();

        allure_Log("Filter by color " + selectedColor);
        searchPage.filter_color_ByName(selectedColor);

        screenShot("Products\\P2", "P3_color");
        allure_LogAttachment("TEST: Filtering color", "Products\\P2", "P3_color");
        Assert.assertTrue(initalResults > searchPage.getTotalProducts(), "ERROR: not filtered by color");
    }

    @Test
    public void P4_availability(){
        String selectedStock = "Out Of Stock";
        int initalResults = searchPage.getTotalProducts();

        allure_Log("Filter by stock " + selectedStock);
        searchPage.filter_stock_ByName(selectedStock);

        screenShot("Products\\P2", "P4_availability");
        allure_LogAttachment("TEST: Filtering stock", "Products\\P2", "P4_availability");
        Assert.assertTrue(initalResults > searchPage.getTotalProducts(), "ERROR: not filtered by stock");
    }
}
