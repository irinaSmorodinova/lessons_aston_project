package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MtsAutoTests {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        switchToMainWindow();
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]"));
        String actualText = blockTitle.getText().replaceAll("\\s+", " ").trim();
        assertEquals(actualText, "Онлайн пополнение без комиссии");
    }

    @Test
    public void testPaymentSystemLogos() {
        switchToMainWindow();

        List<WebElement> logos = driver.findElements(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]//img"));
        assertTrue(!logos.isEmpty(), "Logos are not present");
    }

    @Test
    public void testMoreInfoLink() {
        switchToMainWindow();

        WebElement moreInfoLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        assertTrue(moreInfoLink.isDisplayed(), "More info link is not displayed");

        moreInfoLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 5L);
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"), "More info link did not navigate to the correct page");
    }

    @Test
    public void testContinueButton() {
        switchToMainWindow();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-phone']")));
        phoneNumberField.sendKeys("297777777");

        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-sum']")));
        sumField.sendKeys("100");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        continueButton.click();
    }


    private void switchToMainWindow() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }
}