package Lesson6;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WomenPage extends PageForHW{
    public WomenPage(WebDriver driver) {
        super(driver);
    }

    private final static String SUCCESS_MESSAGE_XPATH_LOCATOR = "//span [.=\"Size\"]";

    @FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_1']//a")
    private List<WebElement> sizes;

    @FindBy(xpath = "//input[@name='layered_id_attribute_group_2']")
    private WebElement chosenElement;

    @FindBy(xpath = "//a[@rel='layered_id_attribute_group_2']")
    private WebElement chosenSize;

    @Step("Выбрать размер")
    public WomenPage chooseSize(String size) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_MESSAGE_XPATH_LOCATOR)));
        sizes.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
        return this;
    }

    @Step("Отмена выбора размера")
    public WomenPage cancelChosenSize() {
        webDriverWait.until(ExpectedConditions.visibilityOf(chosenSize));
        actions.click(chosenSize)
                .build()
                .perform();
        return this;
    }

    public void checkChosen() {
        Assertions.assertFalse(chosenElement.isSelected());
    }

}
