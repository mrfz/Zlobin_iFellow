package ru.iFellow.steps;

import com.codeborne.selenide.Selenide;
import ru.iFellow.components.IssueCreationForm;
import io.qameta.allure.Step;

/**
 * Общие шаги для тестов
 * @author Fedor Zlobin
 */
public class CommonSteps {
    IssueCreationForm issueCreationForm = new IssueCreationForm();

    @Step("Пользователь заполняет поля задачи {taskName} и описание {taskDescription}")
    public void fillTask(String taskName, String taskDescription) {
        issueCreationForm.createIssue(taskName, taskDescription);
    }

    @Step("Обновляем страницу")
    public void updatePage() {
        Selenide.refresh();
    }
}
