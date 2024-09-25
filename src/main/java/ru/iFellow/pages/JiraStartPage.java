package ru.iFellow.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class JiraStartPage {

    private final SelenideElement usernameField = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']");
    private final SelenideElement loginButton = $x("//input[@id='login']");

    public void login(String username, String password) {
        usernameField.shouldBe(Condition.visible)
                .setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }

    public void inputCredentials(String username, String password) {
        usernameField.shouldBe(Condition.visible)
                .setValue(username);
        passwordField.setValue(password);
    }

    public void clickLogin() {
        loginButton.click();
    }


}
