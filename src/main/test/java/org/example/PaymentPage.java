package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PaymentPage {
    private final WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, 20L);
    }

    public List<WebElement> getPaymentSystemLogos() {
        return driver.findElements(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]//img"));
    }

    public WebElement getPhoneNumberField() {
        return driver.findElement(By.xpath("//*[@id='connection-phone']"));
    }

    public WebElement getSumField() {
        return driver.findElement(By.xpath("//*[@id='connection-sum']"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
    }

    public WebElement getPhoneNumberLabel() {
        return driver.findElement(By.xpath("//*[@id='pay-connection']/div[1]/label"));
    }

    public WebElement getSumLabel() {
        return driver.findElement(By.xpath("//*[@id='pay-connection']/div[2]/label"));
    }

    public WebElement getEmailLabel() {
        return driver.findElement(By.xpath("//*[@id='pay-connection']/div[3]/label"));
    }


    public String getCardCVCLabelText() {
        return driver.findElement(By.xpath("//*[@id='cc-cvc']")).getText().replaceAll("\\s+", " ").trim();
    }

    public String getCardHolderNameLabelText() {
        return driver.findElement(By.xpath("//*[@id='cc-holder']")).getText().replaceAll("\\s+", " ").trim();
    }
}