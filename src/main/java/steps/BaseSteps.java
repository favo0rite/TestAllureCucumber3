package steps;

import managers.ManagerPages;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected ManagerPages app = ManagerPages.getManagerPages();

    private static WebDriver driver;

    public static WebDriverWait wait;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver2.exe");

        //ChromeOptions options = new ChromeOptions();
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);

        driver.get("https://www.sberbank.ru/person");
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    public static void tearDown() {
        driver.quit();
    }


}
