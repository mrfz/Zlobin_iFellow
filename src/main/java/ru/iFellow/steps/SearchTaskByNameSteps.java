package ru.iFellow.steps;

import ru.iFellow.components.JiraHeader;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.pages.JiraTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTaskByNameSteps {
    JiraHeader jiraHeaderComponent = new JiraHeader();
    JiraTask jiraTaskPage = new JiraTask();

    @Затем("^Пользователь вводит название задачи '(.*)' в поисковой сроке$")
    public void fillQuickSearch(String taskName) {
        jiraHeaderComponent.fillQuickSearch(taskName);
    }

    @Затем("^Пользователь вызывает задачу '(.*)'$")
    public void openTask(String taskName) {
        jiraHeaderComponent.openFoundedByQuickSearch(taskName);
    }

    @Тогда("^Проверяем что статус задачи '(.*)'$")
    public void checkTaskStatus(String taskStatus) {
        assertEquals(taskStatus, jiraTaskPage.getTaskStatus(), "Task status is incorrect");
    }

    @Тогда("^Проверяем что исправить задачу в '(.*)'$")
    public void checkFixIn(String taskFixIn){
        assertEquals(taskFixIn, jiraTaskPage.getFixVersion(), "Fix version is incorrect");
    }
}
