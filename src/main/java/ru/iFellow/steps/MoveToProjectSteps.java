package ru.iFellow.steps;

import ru.iFellow.components.JiraHeader;
import ru.iFellow.pages.JiraProject;
import ru.iFellow.pages.JiraProjects;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveToProjectSteps {
    JiraHeader jiraHeaderComponent = new JiraHeader();
    JiraProjects jiraProjectsPage = new JiraProjects();
    JiraProject jiraProjectPage = new JiraProject();

    @Step("Пользователь вызывает дашборд проектов")
    public void openProjectsDashboard() {
        jiraHeaderComponent.openProjectsDashboard();
    }

    @Step("Пользователь нажимает на проект Test")
    public void clickOnTestProject() {
        jiraProjectsPage.getTestProjectLink().click();
    }

    @Step("Должно отобразится название проекта Test")
    public void shouldShowProjectName() {
        assertEquals("Test", jiraProjectPage.getProjectName());
    }
}
