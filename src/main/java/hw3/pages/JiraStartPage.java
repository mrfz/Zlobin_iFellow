package hw3.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class JiraStartPage {

    private final SelenideElement usernameField = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']");
    private final SelenideElement loginButton = $x("//input[@id='login']");


    public void open() {
        Selenide.open("https://edujira.ifellow.ru");
    }

    public void login(String username, String password) {
        usernameField.shouldBe(Condition.visible)
                .setValue(username);
        passwordField.setValue(password);
        loginButton.click();

    }


}
