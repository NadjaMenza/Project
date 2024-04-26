package helper;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class Navigation {
    public void navigationForSandwiches(){
        SelenideElement navigationButton = $(byClassName("menu__link menu__link--superdepartment menu__link--active menu__link--current-parent"));
        navigationButton.click();
        SelenideElement navigationButtonSecond = $(byClassName("menu__link menu__link--department"));
        navigationButtonSecond.click();
        SelenideElement navigationButtonThird = $(byClassName("menu__link menu__link--aisle"));
        navigationButtonThird.click();
        SelenideElement header = $(byClassName("heading query"));
        header.shouldBe(visible);
    }
}
