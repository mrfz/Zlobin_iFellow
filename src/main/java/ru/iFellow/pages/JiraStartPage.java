package ru.iFellow.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class JiraStartPage {

    private final SelenideElement usernameField = $x("//input[@id='login-form-username']").as("Поле имени пользователя");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']").as("Поле пароля");
    private final SelenideElement loginButton = $x("//input[@id='login']").as("Кнопка входа");


    public void inputCredentials(String username, String password) {
        usernameField.shouldBe(Condition.visible)
                .setValue(username);
        passwordField.setValue(password);
    }

    public void clickLogin() {
        loginButton.click();
    }


}
