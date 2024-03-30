
import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import io.guyrob.lambda.locate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P2_filters extends base {
    HomePage homepage;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        homepage = new HomePage();

        driver.manage().window().maximize();
        driver.get(testdata.url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        allure_Log("Select category by index " + 6);
        homepage.shopCategory_index(6);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    @Test
    public void P1_price(){
        int maxPrice = 50; // for tests - using 50%, required is 121
        allure_Log("Filter by max price of " + maxPrice);

        WebElement filterMaxPrice = driver.findElement(locate.SP_btn_filter_MaxPrice);
        scrollToExactValue(filterMaxPrice, maxPrice);

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
