package ru.iFellow.steps;

import ru.iFellow.components.JiraHeader;
import ru.iFellow.pages.JiraProject;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckNumberOfIssuesSteps {
    JiraProject jiraProjectPage = new JiraProject();
    JiraHeader jiraHeaderComponent = new JiraHeader();

    int numberOfIssuesBeforeCreation;

    @Step("Запоминаем количество задач")
    public void saveNumberOfIssues() {
        this.numberOfIssuesBeforeCreation = jiraProjectPage.getNumberOfIssues();
    }

    @Step("Пользователь вызывает форму создания задачи")
    public void callCreateIssueForm() {
        jiraHeaderComponent.getCreateIssueButton().click();
    }


    @Step("Проверяем что количество задач увеличилось на 1")
    public void checkNumberOfIssues() {
        assertEquals(numberOfIssuesBeforeCreation + 1, jiraProjectPage.getNumberOfIssues(), "Number of issues is incorrect");
    }}
