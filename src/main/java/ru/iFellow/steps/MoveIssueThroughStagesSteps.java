package ru.iFellow.steps;

import ru.iFellow.pages.JiraProject;
import ru.iFellow.pages.JiraTask;
import io.qameta.allure.Step;

/**
 * Шаги проверки перемещения задачи по стадиям
 * @author Fedor Zlobin
 */
public class MoveIssueThroughStagesSteps {
    JiraTask jiraTaskPage = new JiraTask();
    JiraProject jiraProject = new JiraProject();

    @Step("Пользователь открывает созданную задачу")
    public void openTask() {
        jiraProject.getCreatedIssueLink().click();
    }

    @Step("Пользователь переводит задачу в состояние В работе")
    public void moveIssueToInProgress() {
        jiraTaskPage.moveTaskToInProgress();
    }

    @Step("Пользователь вызывает контекстное меню Бизнес-процесс")
    public void openContextMenuBusinessProcess() {
        jiraTaskPage.getTaskProcess().click();
        jiraTaskPage.checkTaskDoneDropDownVisibility();
    }

    @Step("Пользователь переводит задачу в состояние Выполнено")
    public void moveIssueToDone() {
        jiraTaskPage.getTaskDoneSelection().click();
    }
}
