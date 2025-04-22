package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement getBlockTitle() {
        return driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]"));
    }

    public void clickMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        moreInfoLink.click();
    }

    public void switchToMainWindow() {
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

    public void selectService(String service) {
        WebElement serviceDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[2]/svg")));
        serviceDropdown.click();
        WebElement serviceOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + service + "']")));
        serviceOption.click();
    }
}