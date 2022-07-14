package Lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class AdditionalAllureSteps implements WebDriverListener {
    public void beforeClick(WebElement element) {
        Allure.step("Я кликаю по элементу " + element.getText());
    }
}
