/*
 * (c) guyrob.lambda
 */
package io.guyrob.lambda;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class base {
    public static WebDriver driver;
    public static DevTools devTools;
    public static Actions actions;

    /** Debugging: */
    public void markOverlapElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }

    /**General: */
    public String getCurrentURL() {
        return driver.getCurrentUrl().toLowerCase();
    }



    public void sleep(int time) {
        try {

            Thread.sleep(time);
        } catch (Exception e) {
            allure_FailLog("Exception: " + e);
            System.out.println("Exception: " + e);
        }
    }

    public List<String> switchTab(int tabID) {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowHandlesList.get(tabID));
        return windowHandlesList;
    }

    public static WebElement waitVisibility(int time, By locator) {
        // After clicking the button, wait for the dropdown content to become visible (if necessary)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void screenShot(String folder, String name) {
        try {
            File screenshotsFolder = new File("src\\ExtFiles\\screenShots\\" + folder);
            if (!screenshotsFolder.exists()) {
                screenshotsFolder.mkdirs(); // Create the folder if it doesn't exist
            }

            File destFile = new File(screenshotsFolder, name + ".png");

            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, destFile);

        } catch (Exception e) {
            System.out.println("ERROR: Screenshot failed - " + e.getMessage());
            allure_FailLog("ERROR: Screenshot failed - " + e.getMessage());
        }
    }

    /** Javascript cmds */
    public WebElement getParentElement(WebElement son) {
        WebElement parentAnchor = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].parentNode;", son);
        return parentAnchor;
    }



    /** Actions: */
    public void scroll_Element(WebElement ele){
        actions = new Actions(driver);
        actions.scrollToElement(ele).perform();
    }

    public void scroll_XY(int x, int y){
        actions = new Actions(driver);
        actions.scrollByAmount(x, y).perform();
    }

    public void hoverElement(WebElement ele) {
        // Use the moveToElement method to move the mouse pointer to the specified element
        actions = new Actions(driver);
        actions.moveToElement(ele).perform();
    }

    public void clickElement(WebElement ele){
        actions = new Actions(driver);
        actions.click(ele).build().perform();
    }

    public static String randStr(int length) {
        // Define the characters to be used in the random string
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // Create a Random object
        Random random = new Random();

        // Use StringBuilder to efficiently build the random string
        StringBuilder sb = new StringBuilder(length);

        // Generate random characters until the desired length is reached
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        // Convert StringBuilder to String and return
        return sb.toString();
    }

    /** ============================
     * Allure:
     ===============================*/
    public void allure_Log(String message) {
        Allure.step(message);
    }

    public static void allure_LogAttachment(String info, String folder, String name) {
        String imagePath = "src\\ExtFiles\\screenShots\\" + folder + "\\" + name + ".png";
        Path imageFilePath = Paths.get(imagePath);

        if (Files.exists(imageFilePath) && Files.isReadable(imageFilePath)) {
            try (InputStream imageStream = new FileInputStream(imageFilePath.toFile())) {
                Allure.addAttachment(info, imageStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ERROR: Image file not found or not readable.");
            allure_FailLog("ERROR: Image file not found or not readable.");
        }
    }

    public static void allure_FailLog(String message) {
        Allure.step(message, Status.FAILED);
    }

    //    @TODO not working - need to check
    public void allure_GenerateReport() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "generateAllureReport.sh");
            Process process = processBuilder.start();

            int exitCode = process.waitFor();

            System.out.println("Script execution finished with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
