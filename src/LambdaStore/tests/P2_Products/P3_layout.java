
import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.ProductPages.SearchPage;
import io.guyrob.lambda.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P3_layout extends base {

    HomePage homepage;
    SearchPage searchPage;

    // Test data
    int categoryId = 7;


    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        homepage = new HomePage();
        searchPage = new SearchPage();

        driver.manage().window().maximize();
        driver.get(testdata.url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        allure_Log("Select category by index " + categoryId);
        homepage.shopCategory_index(categoryId);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void P1_viewType(){
        allure_Log("Switching between view type Grid to List");
        searchPage.layout_viewType(1);

        screenShot("Products\\P3", "P1_viewType");
        allure_LogAttachment("TEST: Switched to List", "Products\\P3", "P1_viewType");
        Assert.assertTrue(searchPage.viewTypeListPresent(), "ERROR: not switched to List");
    }


    @Test
    public void P2_showResults(){
        // Switch to 25 results
    }

    @Test
    public void P3_sortByPrice(){

    }

    @Test
    public void P4_sortByName(){

    }


}
