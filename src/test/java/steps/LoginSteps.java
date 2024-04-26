package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import helper.Navigation;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    Navigation navigation = new Navigation();

    @Before
    public void setup() {

        // Set ChromeOptions
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;
        // Open the webpage
        Selenide.open("https://bevasarlas.tesco.hu/groceries/en-GB/");
    }


    //It works
//    WebDriver driver;
//    WebDriverWait wait;
//
//    @Before
//    public void initializeDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-blink-features=AutomationControlled");
//        driver = new ChromeDriver(options);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.manage().window().maximize();
//        driver.get("https://bevasarlas.tesco.hu/groceries/en-GB/");
//
//        WebElement button = driver.findElement(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button"));
//        button.click();
//    }

    @Given("I open tesco online shop")
    public void openWebsite (){
        homePage.isLoaded();
    }
    @And("I accept cookies")
    public void iAcceptCookies() throws InterruptedException {
        //SelenideElement cookieButton = $(byText("Accept all cookies"));
        SelenideElement cookieButton = $(byXpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button"));
        //Assertions.assertTrue(cookieButton.isEnabled());
        cookieButton.click();
        //Thread.sleep(15000);
    }


    @Given("I click Sign in button")
    public void ClickSignInButton() {
        loginPage.pressSighInButtonOnMainPage();
    }

    @When("I enter credentials {string} and {string}")
    public void EnterInvalidCredentials(String email, String psw) {
        loginPage.enterCredentials(email, psw);
    }

    @And("I click on the sign in button")
    public void ClickOnTheSignInButton() {
        loginPage.pressSighInButton();

    }

    @Then("the error message should be displayed {string}")
    public void ErrorMessageIsDisplayed(String expectedError) {
        SelenideElement errorMessage = $(byClassName("styled__StyledBodyText-sc-119w3hf-5 cjzjrS beans-notification__title"));
        String actualError = errorMessage.toString();
        Assertions.assertEquals(expectedError, actualError);
    }

    @Then("I should see a welcome text on home page indicating successful login")
    public void RedirectedToTheHomePage() {
        SelenideElement searchField = $(byId("search-input"));
        Assertions.assertTrue(searchField.exists());
        SelenideElement welcomeText = $(byTagName("h1"));
        Assertions.assertTrue(welcomeText.exists());
    }

    @Given("language is set to {string}")
    public void setLanguage (String newLanguage){
        SelenideElement languageButton = $(byId("utility-header-language-switch-link"));
        SelenideElement currentLanguage = $(byTagName("h1"));

        if (currentLanguage.getText().equals("Gyors és kényelmes bevásárlás")){
            if (newLanguage.equals("hungarian")) {
            }
        }else{
            if (newLanguage.equals("english")){
                languageButton.click();
            }

        }
    }

    @When("I press button hungarian flagMagyar")
    public void PressButtonLanguage() {
        SelenideElement languageButton = $(byId("utility-header-language-switch-link"));
        languageButton.click();
    }

    @Then("language of website is changed to {string}")
    public void languageOfWebsiteIsChangedToHungarian(String expectedLanguage) {
        SelenideElement currentLanguage = $(byTagName("h1"));
        Assertions.assertEquals(expectedLanguage,currentLanguage.getText());
    }

    @Given("I am on the product page of online shop")
    public void navigateProductPage (){
        navigation.navigationForSandwiches();
    }

    @When("I click on the {string}")
    public void ClickOnTheButton (String button) {
        SelenideElement homePageButton = $(byTitle("Go to homepage"));
        SelenideElement homePageBreadCrumbsButton = $(byXpath("//li/div/a[@href = \"/groceries/en-GB/\"]"));

        switch (button) {
            case "logo":
                homePageButton.click();
                break;
            case "breadcrumbs":
                homePageBreadCrumbsButton.click();
                break;
        }
    }

    @Then("I should be directed to the home page")
    public void ShouldBeDirectedToTheHomePage() {
        homePage.isLoaded();
    }

}
