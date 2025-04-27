package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MtsAutoTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedrivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mts.by");

        wait = new WebDriverWait(driver, 30L);

        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Description("Проверка заголовка блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {
        mainPage.switchToMainWindow();
        String actualText = mainPage.getBlockTitle().getText().replaceAll("\\s+", " ").trim();
        assertEquals(actualText, "Онлайн пополнение без комиссии");
    }

    @Test
    @Description("Проверка наличия логотипов платежных систем")
    public void testPaymentSystemLogos() {
        mainPage.switchToMainWindow();
        assertFalse(paymentPage.getPaymentSystemLogos().isEmpty(), "Logos are not present");
    }

    @Test
    @Description("Проверка ссылки 'Подробнее о сервисе'")
    public void testMoreInfoLink() {
        mainPage.switchToMainWindow();
        mainPage.clickMoreInfoLink();
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"), "More info link did not navigate to the correct page");
    }

    @Test
    @Description("Проверка кнопки 'Продолжить'")
    public void testContinueButton() {
        mainPage.switchToMainWindow();
        closeCookieBannerIfPresent();
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOf(paymentPage.getPhoneNumberField()));
        phoneNumberField.sendKeys("297777777");

        WebElement sumField = wait.until(ExpectedConditions.visibilityOf(paymentPage.getSumField()));
        sumField.sendKeys("100");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(paymentPage.getContinueButton()));
        continueButton.click();
    }

    @Test
    @Description("Проверка полей оплаты услуги")
    public void testServicePaymentFields() {
        mainPage.switchToMainWindow();
        closeCookieBannerIfPresent();
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOf(paymentPage.getPhoneNumberField()));
        phoneNumberField.sendKeys("297777777");

        WebElement sumField = wait.until(ExpectedConditions.visibilityOf(paymentPage.getSumField()));
        sumField.sendKeys("100");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(paymentPage.getContinueButton()));
        continueButton.click();

        // Проверка корректности отображения номера телефона
        assertEquals(paymentPage.getPhoneNumberField().getAttribute("value"), "(29)777-77-77", "Incorrect phone number displayed");

        // Ожидание видимости и проверка надписей в незаполненных полях для ввода реквизитов карты
        System.out.println("Attempting to find card expiry label text...");
        WebDriverWait localWait = new WebDriverWait(driver, 5L); // Локальное время ожидания
        WebElement cardExpiryElement = localWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/input")));
        String cardExpiryLabelText = cardExpiryElement.getAttribute("placeholder").replaceAll("\\s+", " ").trim();
        assertEquals(cardExpiryLabelText, "Срок действия", "Incorrect label for card expiry");

        System.out.println("Attempting to find card CVC label text...");
        String cardCVCLabelText = paymentPage.getCardCVCLabelText();
        assertEquals(cardCVCLabelText, "CVC", "Incorrect label for card CVC");

        System.out.println("Attempting to find card holder name label text...");
        String cardHolderNameLabelText = paymentPage.getCardHolderNameLabelText();
        assertEquals(cardHolderNameLabelText, "Имя держателя (как на карте)", "Incorrect label for card holder name");

        // Проверка наличия иконок платёжных систем
        assertFalse(paymentPage.getPaymentSystemLogos().isEmpty(), "Payment system logos are not present");
    }

    @Test
    @Description("Проверка полей для всех опций услуг")
    public void testServiceFieldsForAllOptions() {
        mainPage.switchToMainWindow();
        closeCookieBannerIfPresent();

        // Проверка полей для "Услуги связи"
        checkServiceFields("Услуги связи", "+375", "E-mail для отправки чека");

        // Проверка полей для "Домашний интернет"
        mainPage.selectService("Домашний интернет");
        checkServiceFields("Домашний интернет", "Номер телефона", "Email для отправки");

        // Проверка полей для "Рассрочка"
        mainPage.selectService("Рассрочка");
        checkServiceFields("Рассрочка", "Номер телефона", "Email для отправки");

        // Проверка полей для "Задолженность"
        mainPage.selectService("Задолженность");
        checkServiceFields("Задолженность", "Номер телефона", "Email для отправки");
    }

    @Step("Проверка полей для услуги {service}")
    private void checkServiceFields(String service, String phoneLabel, String emailLabel) {
        mainPage.selectService(service);
        assertEquals(paymentPage.getPhoneNumberLabel().getText(), phoneLabel, "Incorrect label for phone number");
        assertEquals(paymentPage.getSumLabel().getText(), "Сумма", "Incorrect label for sum");
        assertEquals(paymentPage.getEmailLabel().getText(), emailLabel, "Incorrect label for email");
    }

    @Step("Закрытие баннера cookie, если он присутствует")
    private void closeCookieBannerIfPresent() {
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie")));
            WebElement closeButton = cookieBanner.findElement(By.xpath(".//button[contains(text(), 'Принять')]"));
            closeButton.click();
            wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
        } catch (Exception e) {
            // Если баннер не найден, продолжаем выполнение теста
        }
    }
}