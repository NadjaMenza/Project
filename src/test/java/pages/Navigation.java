package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class Navigation {
    public void navigationFirstMenu(String xPath){
        SelenideElement navigationButton = $(byClassName(xPath));
        navigationButton.click();
        //add waiting
    }
    public void navigationSecondMenu(String xPath){
        SelenideElement navigationButtonSecond = $(byClassName(xPath));
        navigationButtonSecond.click();
        //add waiting
    }
    public void navigationThirdMenu(String xPath){
        SelenideElement navigationButtonThird = $(byClassName(xPath));
        navigationButtonThird.click();
        SelenideElement header = $(byClassName("heading query"));
        header.shouldBe(visible);
    }
}
