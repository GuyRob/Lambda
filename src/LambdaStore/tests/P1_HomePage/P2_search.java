import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.ProductPages.SearchPage;
import io.guyrob.lambda.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.testdata;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P2_search  extends base {
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

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void P1_ipod(){
        String searchedText = "ipod";
        allure_Log("Search " + searchedText);
        homepage.search(searchedText);

        boolean searched = searchPage.getSearch().contains(searchedText);
        boolean searchedProductContains = searchPage.getProductName(searchPage.getProducts().get(1)).toLowerCase().contains(searchedText);

        screenShot("HomePage\\P2", "P1_ipod");
        allure_LogAttachment("TEST: Title and products contains " + searchedText, "HomePage\\P2", "P1_ipod");
        Assert.assertTrue(searched && searchedProductContains, "ERROR: Title or products not contains " + searchedText);
    }


    @Test
    public void P2_misspelled(){
        // Expected result: Suggestions for correct spelling or display of results matching the closest query.
        String searchedText = "Apple Cenema";
        allure_Log("Search " + searchedText);
        homepage.search(searchedText);

        String expectedSearch = "apple";
        boolean searched = searchPage.getSearch().contains(expectedSearch);

        screenShot("HomePage\\P2", "P2_misspelled");
        allure_LogAttachment("TEST: Title is correct, and showing products without misspelled", "HomePage\\P2", "P2_misspelled");

        boolean searchedProductContains = searchPage.getProductName(searchPage.getProducts().get(1)).toLowerCase().contains(expectedSearch); // BUG - LA-6
        Assert.assertTrue(searched && searchedProductContains, "ERROR: Title or products not contains " + expectedSearch);
    }



    @Test
    public void P3_randomLongString(){
        // Expected Result: Get no results
        String searchedText = randStr(40);
        allure_Log("Search " + searchedText);
        homepage.search(searchedText);

        boolean searched = searchPage.getSearch().contains(searchedText);
        boolean resulsZero = searchPage.getProductDescription(0).contains("no product");

        screenShot("HomePage\\P2", "P3_randomLongString");
        allure_LogAttachment("TEST: Title is correct, and showing no results", "HomePage\\P2", "P3_randomLongString");
        Assert.assertTrue(searched && resulsZero, "ERROR: Title not match to: " + searchedText + ", or products are found");
    }



}
