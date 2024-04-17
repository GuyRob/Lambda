import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.concurrent.TimeUnit;


public class P1_sections extends base {

    HomePage homepage;

    // Data
    String collection_Category = "BEST SELLER";


    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        homepage = new HomePage();

        driver.manage().window().maximize();
        driver.get(testdata.url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sleep(1000);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }



    @Test
    public void P1_trendingCategories(){
        // BUG - LA-5
        allure_Log("Scrolling to trending section");
        scroll_Element(driver.findElement(locate.HP_list_trnd_Categories));

        allure_Log("Select top category");
        boolean isIndexDisplay = homepage.trnd_SelectIndex(1);
        screenShot("HomePage\\P1", "P1_trendingCategories"); // TODO fix screenshot issue on this class
        allure_LogAttachment("Showing Top Trending Category Page", "HomePage\\P1", "P1_trendingCategories");

        boolean isUrlChanged = !(getCurrentURL()).equals(testdata.url);
        if (isUrlChanged){
            driver.navigate().back();
        }

        allure_Log("TEST: Index display and navigated to trending category successfully");
        Assert.assertTrue(isIndexDisplay && isUrlChanged, "ERROR: Selecting index or top category failed");
    }

    @Test
    public void P2_topProducts(){
    // Next and compare HTC
        allure_Log("Scrolling to top products section");
        scroll_Element(driver.findElement(locate.HP_list_topp_Products));

        allure_Log("Clicking on next button");
        homepage.topp_Next();
        homepage.topp_Next();


        allure_Log("Comparing HTC products");
        homepage.topp_compareByName("HTC");
        screenShot("HomePage\\P1", "P2_topProducts");
        allure_LogAttachment("Products compare", "HomePage\\P1", "P2_topProducts");

        allure_Log("TEST: Compare products alert displayed");
        Assert.assertTrue(homepage.topp_compareAlert_isDisplayed());
    }

    @Test
    public void P3_collection(){

        allure_Log("Scrolling to collection section");
        scroll_Element(driver.findElement(By.xpath(locate.HP_list_coll_Products)));

        allure_Log("Selecting quick view product");
        homepage.coll_quickView(5);
        screenShot("HomePage\\P1", "P3_collection");
        allure_LogAttachment("Quick View Page", "HomePage\\P1", "P3_collection");

        allure_Log("TEST: Quick view displayed and exit successfully");
        homepage.coll_quickViewExit(); // will fail if quick view not open @todo need to check why failing

        allure_Log("Selecting category " + collection_Category);
        boolean isdCategoryDisplay = homepage.coll_SelectCategory(collection_Category);
        allure_Log("Clicking on next button");
        homepage.coll_Next();

        allure_Log("TEST: Selected category and clicked next successfully");
        Assert.assertTrue(isdCategoryDisplay &&  homepage.coll_PrevIsDisaplyed(), "ERROR: Category or Next button failed");
    }



}
