package ru.iFellow.steps;

import com.codeborne.selenide.Condition;
import ru.iFellow.components.JiraHeader;
import ru.iFellow.pages.JiraTask;
import io.qameta.allure.Step;

import java.time.Duration;

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
        jiraTaskPage.getTaskStatus().shouldHave(Condition.text(taskStatus), Duration.ofSeconds(5));
    }

    @Step("Проверяем что исправить задачу в {taskFixIn}")
    public void checkFixIn(String taskFixIn){
        assertEquals(taskFixIn, jiraTaskPage.getFixVersion(), "Fix version is incorrect");
    }
}
