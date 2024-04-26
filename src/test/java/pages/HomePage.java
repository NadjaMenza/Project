package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    SelenideElement search = $(byId("search-input"));

    SelenideElement languageButton = $(byId("utility-header-language-switch-link"));
    SelenideElement currentLanguage = $(byTagName("h1"));

    public void isLoaded (){
        search.shouldBe(visible, enabled);
    }


}
