import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lesson5 {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().fullscreen();
    }

    @Test
    void chooseAllSizes() throws InterruptedException {
        WebElement cat = driver.findElement(By.xpath("//a[.='Women']"));
        cat.click();
        WebElement sizeS = driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_1']"));
        WebElement sizeM = driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_2']"));
        WebElement sizeL = driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_3']"));
        sizeS.click();
        sizeM.click();
        sizeL.click();
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_1']")).
                isSelected());
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_2']")).
                isSelected());
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_3']")).
                isSelected());
        Thread.sleep(3000);
    }

    @Test
    void unchooseSizeM() throws InterruptedException {
        WebElement cat = driver.findElement(By.xpath("//a[.='Women']"));
        cat.click();
        WebElement sizeM = driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_2']"));
        sizeM.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//a[@rel='layered_id_attribute_group_2']")));
        driver.findElement(By.xpath("//a [@rel='layered_id_attribute_group_2']")).click();
        Assertions.assertFalse(driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_2']")).
                isSelected());
        Thread.sleep(3000);
    }

    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
