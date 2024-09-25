package ru.iFellow.steps;

import ru.iFellow.components.JiraHeader;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.pages.JiraProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckIssuesCounterSteps {

    JiraProject jiraProjectPage = new JiraProject();
    JiraHeader jiraHeaderComponent = new JiraHeader();

    int numberOfIssuesBeforeCreation;

    @Затем("Запоминаем количество задач")
    public void saveNumberOfIssues() {
        this.numberOfIssuesBeforeCreation = jiraProjectPage.getNumberOfIssues();
    }

    @Затем("Пользователь вызывает форму создания задачи")
    public void callCreateIssueForm() {
        jiraHeaderComponent.getCreateIssueButton().click();
    }


    @Тогда("Проверяем что количество задач увеличилось на 1")
    public void checkNumberOfIssues() {
        assertEquals(numberOfIssuesBeforeCreation + 1, jiraProjectPage.getNumberOfIssues(), "Number of issues is incorrect");
    }
}
