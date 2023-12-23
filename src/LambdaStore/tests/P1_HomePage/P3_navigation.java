import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P3_navigation extends base {

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
    public void P1_home(){

    }

    @Test
    public void P2_special(){

    }

    @Test
    public void P3_blog(){

    }

    @Test
    public void P4_megaMenu(){
        // Bug - instead of leading to mega menu leads to about us
    }

    @Test
    public void P5_addons(){
        // Bug - not leads to any page
    }

    @Test
    public void P6_myAccount(){

    }

}
