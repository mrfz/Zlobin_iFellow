package hw3.steps;

import hw3.components.JiraHeader;
import hw3.pages.JiraTask;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTaskByNameSteps {
    JiraHeader jiraHeaderComponent = new JiraHeader();
    JiraTask jiraTaskPage = new JiraTask();

    @Step("Пользователь вводит название задачи {taskName} в поисковой сроке")
    public void fillQuickSearch(String taskName) {
        jiraHeaderComponent.fillQuickSearch(taskName);
    }

    @Step("Пользователь вызывает задачу {taskName}")
    public void openTask(String taskName) {
        jiraHeaderComponent.openFoundedByQuickSearch(taskName);
    }

    @Step("Проверяем что статус задачи {taskStatus}")
    public void checkTaskStatus(String taskStatus) {
        assertEquals(taskStatus, jiraTaskPage.getTaskStatus(), "Task status is incorrect");
    }

    @Step("Проверяем что исправить задачу в {taskFixIn}")
    public void checkFixIn(String taskFixIn){
        assertEquals(taskFixIn, jiraTaskPage.getFixVersion(), "Fix version is incorrect");
    }
}
