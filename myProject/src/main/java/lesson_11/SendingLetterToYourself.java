package lesson_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendingLetterToYourself {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void authorization() {
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath("(//button[text()='Войти'])[2]")).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("andersen2022lessons");
        driver.findElement(By.xpath("//span[text()='Ввести пароль']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("oYI3RyUi1i*u");
        driver.findElement(By.xpath("//span[text()='Войти']")).click();
        driver.switchTo().defaultContent();
    }

    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void sendKeys(WebElement element, String phrase) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(phrase);
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "D:\\Olka\\MySelenium\\myProject\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        authorization();
        click(driver.findElement(By.xpath("//div[@class='compose-dropdown']")));
        click(driver.findElement(By.xpath("//span[text()='Написать себе']")));
        sendKeys(driver.findElement(By.xpath("//input[@name='Subject']")), "Просто письмо");
        sendKeys(driver.findElement(By.xpath("//div[@role='textbox']")), "Здесь должен быть какой-нибудь текст");
        click(driver.findElement(By.xpath("//span[text()='Отправить']")));
        driver.quit();
    }
}
