package tests.P2_Products;

import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P3_layout extends base {

    HomePage homepage;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        homepage = new HomePage();

        driver.manage().window().maximize();
        driver.get(testdata.url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    @Test
    public void P1_searchAndCriteria(){
        // Bug - search "a" and add criteria: sub category and search - expected: to show less results but showing the same amount
    }

    @Test
    public void P2_viewType(){
        // Switch between List and Grid
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
