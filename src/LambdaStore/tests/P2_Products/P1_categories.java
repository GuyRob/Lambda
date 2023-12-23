package tests.P2_Products;

import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P1_categories extends base {

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
    public void P1_phoneAndTablets(){
        // Bug - Check title contains phone and tablets

    }

    @Test
    public void P2_laptops(){
        // Bug - Filter by windows and check each product not contains Mac/Apple


    }

    @Test
    public void P3_gamingConsole(){
        // Bug - not leads to any category
    }

}
