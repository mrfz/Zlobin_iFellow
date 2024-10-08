package hw3.steps;

import com.codeborne.selenide.Selenide;
import hw3.components.IssueCreationForm;
import io.qameta.allure.Step;

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
