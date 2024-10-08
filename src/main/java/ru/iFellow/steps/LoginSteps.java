package ru.iFellow.steps;

import com.codeborne.selenide.Selenide;
import ru.iFellow.components.JiraHeader;
import ru.iFellow.pages.JiraStartPage;
import ru.iFellow.utils.CredentialsManager;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigCache;

public class LoginSteps{
    CredentialsManager credentialsManager = ConfigCache.getOrCreate(CredentialsManager.class);
    JiraStartPage jiraStartPage = new JiraStartPage();
    JiraHeader jiraHeaderComponent = new JiraHeader();



    @Step("Пользователь открывает браузер на странице входа в портал")
    public void browserOpen() {

        Selenide.open(credentialsManager.url());
    }

    @Step("Пользователь вводит имя пользователя и пароль")
    public void login()  {

        jiraStartPage.inputCredentials(credentialsManager.username(), credentialsManager.password());
    }

    @Step("Пользователь нажимает на кнопку Войти")
    public void pressSubmitButton() {
        jiraStartPage.clickLogin();
    }

    @Step("В меню опций пользователя появляется кнопка Выйти")
    public void checkLogoutButton() {
        jiraHeaderComponent.logoutButtonExists();
    }
}
