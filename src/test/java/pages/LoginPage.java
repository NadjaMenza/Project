package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement signInButtonHomePage = $(byClassName("signin-register--signin-button"));
    SelenideElement fieldEmail = $(byId("email"));
    SelenideElement fieldPsw = $(byId("password"));
    SelenideElement signInButton = $(byId("signin-button"));
    //SelenideElement errorMessage = $(byClassName("styled__StyledBodyText-sc-119w3hf-5 cjzjrS beans-notification__title"));

    public void pressSighInButtonOnMainPage(){
        signInButtonHomePage.click();
        fieldEmail.shouldBe(visible,enabled);
        fieldPsw.shouldBe(visible,enabled);
    }
    public void enterCredentials (String email, String psw){
        fieldEmail.sendKeys(email);
        fieldPsw.sendKeys(psw);
    }
    public void pressSighInButton (){
        signInButton.click();
    }

}
