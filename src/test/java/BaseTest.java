import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static java.lang.Thread.*;


public class BaseTest {
    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String koelUrl = BaseUrl;
        driver.navigate().to(koelUrl);

    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();

    }


    protected static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.click();
        emailField.sendKeys(email);

    }

    protected static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);

    }

    protected static void clickSubmit() throws InterruptedException {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();
        Thread.sleep(3000);
    }

    protected static void clickPLaylist() throws InterruptedException {
        WebElement playlistName = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3)"));
        playlistName.click();
        Thread.sleep(3000);
    }

    protected static void deletePlaylistBtn() throws InterruptedException {
        WebElement deleteBtn = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        deleteBtn.click();
        Thread.sleep(3000);
    }

    public String notification()  {
        WebElement deletedPlaylist = driver.findElement(By.cssSelector("div.success.show"));
        return deletedPlaylist.getText();

    }
}