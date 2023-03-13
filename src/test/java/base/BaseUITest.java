package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseUITest {

    private WebDriver driver;
    private WebDriverWait wait;

    private Actions actions;

    private JavascriptExecutor js;
    public static Properties prop = new Properties();
    public static FileReader fr;

    public static String[] files = new String[5];

    private boolean isChrome = false;
    private boolean isEdge = false;
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws IOException
    {

        if (driver == null) {
            fr = new FileReader("src/test/configfiles/config.properties");
            prop.load(fr);
        }

        files[0] = prop.getProperty("dummyCsv");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            isChrome = true;
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            //options.addArguments("--remote-debugging-port");
            options.addArguments("fission.bfcacheInParent=false");
            options.addArguments("fission.webContentIsolationStrategy=0");
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
            isEdge = true;
        }
        int durationVal = Integer.parseInt(prop.getProperty("driverTimeOut"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(durationVal));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.get(prop.getProperty("websiteUrl"));
        if (isChrome || isEdge) {
            WebElement advancedButton = findByXPath("//button[@id='details-button']");
            advancedButton.click();
            WebElement proceedLink = findByXPath("//a[@id='proceed-link']");
            proceedLink.click();
        }
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }

    public  WebElement findByXPath(String xpath)
    {
        return driver.findElement(By.xpath(xpath));
    }

    public  WebElement waitForElementVisibility(String xpath)
    {
        return wait.until(ExpectedConditions.visibilityOf(findByXPath(xpath)));
    }

    public  WebElement waitForElementToExist(String xpath)
    {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public  void waitForTextToExistInInputElement(String xpath)
    {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(findByXPath(xpath), "value"));
    }

    public  void clearInputElement(WebElement element)
    {
        for (int i = 0; i < element.getAttribute("value").length(); i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.sendKeys(Keys.BACK_SPACE);
    }

    public  void scrollToElement(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void navigateToSwaggerApiDocumentationPage()
    {
        driver.get(prop.getProperty("websiteUrl") + "/api/docs");
    }
}