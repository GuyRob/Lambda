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
    public void P1_ipod(){ // TODO add screenshots and logs
        String searchedText = "ipod";
        homepage.search(searchedText);
        boolean searched = searchPage.getSearch().contains(searchedText);
        boolean searchedProductContains = searchPage.getProductName(searchPage.getProducts().get(1)).toLowerCase().contains(searchedText);
        Assert.assertTrue(searched && searchedProductContains, "ERROR: Title or products not contains " + searchedText);
    }


    @Test
    public void P2_misspelled(){
        // Expected result: Suggestions for correct spelling or display of results matching the closest query.
        String searchedText = "Apple Cenema";
        homepage.search(searchedText);

        String expectedSearch = "Apple";
        boolean searched = searchPage.getSearch().contains(expectedSearch);

        boolean searchedProductContains = searchPage.getProductName(searchPage.getProducts().get(1)).toLowerCase().contains(expectedSearch); // TODO need to handle out bound issue
        System.out.println(searched);
        System.out.println(searchedProductContains);

        Assert.assertTrue(searched && searchedProductContains, "ERROR: Title or products not contains " + expectedSearch);
    }



    @Test
    public void P5_randomLongString(){
        // Expected Result: Get no results
        String searchedText = "aggsagagwagagw"; // TODO create a function that create longString
        homepage.search(searchedText);

        boolean searched = searchPage.getSearch().contains(searchedText);
        boolean resulsZero = searchPage.getResults() == 0; // TODO create get results

        Assert.assertTrue(searched && resulsZero, "ERROR: Title not match to: " + searchedText + ", or products are found");
    }



}
