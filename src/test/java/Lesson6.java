import Lesson6.GoToWomanPage;
import Lesson7.AdditionalAllureSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class Lesson6 {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalAllureSteps()).decorate(new ChromeDriver());
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().fullscreen();
    }

    @Test
    void chooseSizeM() throws InterruptedException {
        new GoToWomanPage(driver)
                .clickToButton()
                .chooseSize("M")
                .cancelChosenSize()
                .checkChosen();
    }
     @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
