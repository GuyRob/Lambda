package tests.P3_Authentication;

import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P1_registerLogout extends base {

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
    public void P1_myAccount(){

    }

    @Test
    public void P2_newCustomer(){

    }

    @Test
    public void P3_logout(){

    }

}
