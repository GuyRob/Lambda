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
//        driver.quit();
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
        allure_Log("Scrolling to top products section");
        scroll_Element(driver.findElement(locate.HP_list_topp_Products));

        allure_Log("Clicking on next button");
        homepage.topp_Next();
        homepage.topp_Next();


        allure_Log("Comparing HTC products"); // @TODO create function

    }

    @Test
    public void P3_collection(){

        allure_Log("Scrolling to collection section");
        scroll_Element(driver.findElement(By.xpath(locate.HP_list_coll_Products)));

        allure_Log("Selecting quick view product");
        homepage.coll_quickView(5);
        allure_LogAttachment("Collection Quick View", "HomePage\\P1", "P3_collection_View"); // @TODO need to check why not capturing  
        homepage.coll_quickViewExit();

        allure_Log("Selecting category " + collection_Category);
        boolean isdCategoryDisplay = homepage.coll_SelectCategory(collection_Category);
        allure_Log("Clicking on next button");
        homepage.coll_Next();

        Assert.assertTrue(isdCategoryDisplay &&  homepage.coll_PrevIsDisaplyed(), "ERROR: Category or Next button failed");


    }



}
