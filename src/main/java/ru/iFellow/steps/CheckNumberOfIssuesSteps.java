package ru.iFellow.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.iFellow.components.JiraHeader;
import ru.iFellow.pages.JiraProject;

import java.time.Duration;

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
        jiraProjectPage.getNumberOfIssuesElement().shouldHave(
                Condition.text(String.valueOf(numberOfIssuesBeforeCreation+1)),
                Duration.ofSeconds(6));
    }}
