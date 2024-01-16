import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
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
        allure_Log("Scrolling to trending section");
        scroll_Element(driver.findElement(locate.HP_list_trnd_Categories));
        allure_Log("Select top category");
        boolean isIndexDisplay = homepage.trnd_SelectIndex(1);
        allure_LogAttachment("Top Category Page", "HomePage\\P1", "P1_trendingCategories");
        boolean isUrlChanged = !(getCurrentURL()).equals(testdata.url);
        if (isUrlChanged){
            driver.navigate().back();
        }

        Assert.assertTrue(isIndexDisplay && isUrlChanged, "ERROR: Selecting index or top category failed");
    }

    @Test
    public void P2_topProducts(){
    // Next and compare HTC

    }

    @Test
    public void P3_collection(){
        allure_Log("Scrolling to collection section");
        scroll_Element(driver.findElement(locate.HP_list_coll_Products));
        allure_Log("Selecting category " + collection_Category);
        boolean isdCategoryDisplay = homepage.coll_SelectCategory(collection_Category);
        allure_Log("Clicking on next button");
        homepage.coll_Next();
        allure_LogAttachment("Collection", "HomePage\\P1", "P1_trendingCategories"); // need to check why not capturing

        Assert.assertTrue(isdCategoryDisplay && homepage.coll_PrevIsDisaplyed(), "ERROR: Category or Next button failed");


    }

    // Maybe add a test that checks the banner size (above top products) - the image size is smaller than banner size (bug)
//    @Test
//    public void P5_bannerSize(){
//
//    }



}
