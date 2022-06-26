import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Lesson6.GoToWomanPage;
import Lesson6.PageForHW;

public class Lesson6 {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
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
