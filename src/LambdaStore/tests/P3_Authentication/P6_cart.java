package tests.P3_Authentication;

import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P6_cart extends base {
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

    // TODO check if there is an option to call "P2_Login" class before tests
    //

    @Test
    public void P1_cart(){

    }

    @Test
    public void P2_removeProduct(){
        // Remove product in cart
    }

    @Test
    public void P3_changeQTY(){

    }

    @Test
    public void P4_addTaxes(){
        // add tax calculation
    }

    @Test
    public void P5_checkout(){

    }

    @Test
    public void P6_addComment(){

    }

    @Test
    public void P7_agreeContinueAndConfirm(){

    }

}
