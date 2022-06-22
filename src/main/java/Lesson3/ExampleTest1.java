package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleTest1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver w = new ChromeDriver();
        w.get("http://automationpractice.com/index.php");
        WebElement cat = w.findElement(By.xpath("//a [. = 'Women']"));
        cat.click();
        WebElement sizeS= w.findElement(By.xpath("//input [@name = 'layered_id_attribute_group_1']"));
        WebElement sizeM = w.findElement(By.xpath("//input [@name = 'layered_id_attribute_group_2']"));
        WebElement sizeL = w.findElement(By.xpath("//input [@name = 'layered_id_attribute_group_3']"));
        sizeS.click();
        sizeM.click();
        sizeL.click();

        WebDriverWait webDriverWait = new WebDriverWait(w, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@rel = 'layered_id_attribute_group_2']")));
        w.findElement(By.xpath("//a [@rel = 'layered_id_attribute_group_2']")).click();

        Thread.sleep(3000);

        w.quit();


    }
}
