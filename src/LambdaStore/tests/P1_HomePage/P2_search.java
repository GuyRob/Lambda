import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P2_search  extends base {
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
    public void P1_ipod(){
        homepage.search("ipod");
    }

    @Test
    public void P2_dot(){

    }

    @Test
    public void P3_misspelled(){
        // Expected result: Suggestions for correct spelling or display of results matching the closest query.
    }

    @Test
    public void P4_partNameSuggest(){
        // Start typing name: "ip" - select from suggestion "ipod classic" (on each char in search try to select)
    }

    @Test
    public void P5_randomLongString(){
        // Get no results
    }



}
