package homeWork.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunctions {

    WebDriver driver;

    private static final String FIREFOX_DRIVER_PATH = "D:/QA2_drivers/geckodriver.exe";
    private static final Logger LOGGER = LogManager.getLogger(BaseFunctions.class);

    public BaseFunctions() {

        LOGGER.info("Setting driver path to system properties");
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);

        LOGGER.info("Starting FireFox Driver");
        this.driver = new FirefoxDriver();

        LOGGER.info("Maximize browser window");
        driver.manage().window().maximize();

    }

    public void goToURL(String url) {
        LOGGER.info("Open URL: " + url);
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        LOGGER.info("Getting list of elements");
        return driver.findElements(locator);
    }

    public void clickElement(By locator) {
        LOGGER.info("Click Element");
        driver.findElement(locator).click();
    }

    public WebElement getElement(By locator) {
        LOGGER.info("Getting element");
        return driver.findElement(locator);

    }

    public void fillInputField(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public void selectFromDropDown(By locator, String toSelect) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(toSelect);
    }

    public String runJavaScript(String script) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        if (javascriptExecutor.executeScript(script) != null) {
            return javascriptExecutor.executeScript(script).toString();
        }
        return null;
    }

    public void changeWindowSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void implicityWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void pressEnter() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
