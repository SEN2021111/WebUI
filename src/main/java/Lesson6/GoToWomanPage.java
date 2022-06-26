package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoToWomanPage extends PageForHW{

    public GoToWomanPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Women']")
    private WebElement womenButton;

    public WomenPage clickToButton() {
        actions.moveToElement(womenButton)
                .click()
                .build()
                .perform();
        return new WomenPage(driver);
    }

}
