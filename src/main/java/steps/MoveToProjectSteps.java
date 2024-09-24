package steps;

import components.JiraHeader;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import pages.JiraProject;
import pages.JiraProjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveToProjectSteps {

    JiraHeader jiraHeaderComponent = new JiraHeader();
    JiraProjects jiraProjectsPage = new JiraProjects();
    JiraProject jiraProjectPage = new JiraProject();

    @Затем("Пользователь вызывает дашборд проектов")
    public void openProfectsDashboard() {
        jiraHeaderComponent.openProjectsDashboard();
    }

    @Затем("Пользователь нажимает на проект Test")
    public void clickOnTestProject() {
        jiraProjectsPage.getTestProjectLink().click();
    }

    @Тогда("Должно отобразится название проекта Test")
    public void shouldShowProjectName() {
        assertEquals("Test", jiraProjectPage.getProjectName());
    }
}
