package steps;

import com.codeborne.selenide.Selenide;
import components.JiraHeader;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.aeonbits.owner.ConfigCache;
import pages.JiraStartPage;
import utils.CredentialsManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    CommonSteps commonSteps = new CommonSteps();
    CredentialsManager credentialsManager = ConfigCache.getOrCreate(CredentialsManager.class);
    JiraStartPage jiraStartPage = new JiraStartPage();
    JiraHeader jiraHeaderComponent = new JiraHeader();



    @Дано("^Пользователь открывает браузер на странице входа в портал")
    public void browserOpen() {

        Selenide.open(credentialsManager.url());
    }

    @Когда("Пользователь вводит имя пользователя и пароль")
    public void Login()  {

        jiraStartPage.inputCredentials(credentialsManager.username(), credentialsManager.password());
    }

    @Затем("Пользователь нажимает на кнопку Войти")
    public void pressSubmitButton() {
        jiraStartPage.clickLogin();
    }

    @Тогда("В меню опций пользователя появляется кнопка Выйти")
    public void checkLogoutButton() {
        assertTrue(jiraHeaderComponent.logoutButtonExists(), "Login failed");
    }


}
