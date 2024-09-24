package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import components.IssueCreationForm;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Затем;
import utils.ConfigurationManager;

public class CommonSteps {

    IssueCreationForm issueCreationForm = new IssueCreationForm();

    @Before
    public static void before() {
        WebDriverRunner.setWebDriver(ConfigurationManager.getWebDriver());
    }

    @After
    public static void after() {
        Selenide.closeWebDriver();
    }

    @Затем("^Пользователь заполняет поля задачи '(.*)', '(.*)'$")
    public void fillTask(String taskName, String taskDescription) {
        issueCreationForm.createIssue(taskName, taskDescription);
    }

    @Затем("Обновляем страницу")
    public void updatePage() {
        Selenide.sleep(2000);
        Selenide.refresh();
        Selenide.sleep(2000);
    }
}
