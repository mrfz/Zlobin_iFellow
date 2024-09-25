package ru.iFellow.steps;

import com.codeborne.selenide.Selenide;
import ru.iFellow.components.IssueCreationForm;
import io.cucumber.java.ru.Затем;

public class CommonSteps {

    IssueCreationForm issueCreationForm = new IssueCreationForm();

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
