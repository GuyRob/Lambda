
import io.guyrob.lambda.ProductPages.HomePage;
import io.guyrob.lambda.ProductPages.SearchPage;
import io.guyrob.lambda.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.testdata;

import java.util.concurrent.TimeUnit;

public class P1_categories extends base {

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
    public void P1_cameras(){
        int camerasIndex = 2;
        String camerasCategoryName = "cameras";

        allure_Log("Select category by index " + camerasIndex);
        homepage.shopCategory_index(camerasIndex);

        screenShot("Products\\P1", "P1_cameras");
        allure_LogAttachment("TEST: Title contains " + camerasCategoryName, "Products\\P1", "P1_cameras");
        Assert.assertEquals(searchPage.getTitle().toLowerCase(), camerasCategoryName);
    }

    @Test
    public void P2_phoneAndTablets(){
        // Bug - Check title contains phone and tablets
        int tabletIndex = 3;
        String tabletCategoryName = "phone, tablets & ipod";

        allure_Log("Select category by index " + tabletIndex);
        homepage.shopCategory_index(tabletIndex);

        screenShot("Products\\P1", "P2_phoneAndTablets");
        allure_LogAttachment("TEST: Title contains " + tabletCategoryName, "Products\\P1", "P2_phoneAndTablets");
        Assert.assertEquals(searchPage.getTitle().toLowerCase(), tabletCategoryName); // BUG - LA-10
    }

    @Test
    public void P3_gamingConsole(){
        // Bug - not leads to any category
        int tabletIndex = 14;
        String tabletCategoryName = "gaming consoles";

        allure_Log("Select category by index " + tabletIndex);
        homepage.shopCategory_index(tabletIndex);

        screenShot("Products\\P1", "P3_gamingConsole");
        allure_LogAttachment("TEST: Title contains " + tabletCategoryName, "Products\\P1", "P3_gamingConsole");
        Assert.assertEquals(searchPage.getTitle().toLowerCase(), tabletCategoryName); // BUG - LA-11
    }

}
