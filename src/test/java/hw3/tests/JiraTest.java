package hw3.tests;

import com.codeborne.selenide.Selenide;
import hw3.Hooks.WebHook;
import hw3.components.IssueCreationForm;
import hw3.components.JiraHeader;
import hw3.pages.JiraProject;
import hw3.pages.JiraProjects;
import hw3.pages.JiraStartPage;
import hw3.pages.JiraTask;
import hw3.steps.LoginSteps;
import hw3.steps.MoveToProjectSteps;
import hw3.utils.CredentialsManager;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестирование Jira")
public class JiraTest extends WebHook {

    @Test
    @DisplayName("Проверка авторизации")
    public void loginTest() {
        LoginSteps loginSteps = new LoginSteps();

        loginSteps.browserOpen();
        loginSteps.login();
        loginSteps.pressSubmitButton();
        loginSteps.checkLogoutButton();

    }

    @Test
    @DisplayName("Проверка перехода на проект")
    public void moveToProjectTest() {
        LoginSteps loginSteps = new LoginSteps();
        MoveToProjectSteps moveToProjectSteps = new MoveToProjectSteps();

        loginSteps.browserOpen();
        loginSteps.login();
        loginSteps.pressSubmitButton();

        moveToProjectSteps.openProjectsDashboard();
        moveToProjectSteps.clickOnTestProject();
        moveToProjectSteps.shouldShowProjectName();

    }

    @Test
    @DisplayName("Проверка счетчика количества задач")
    public void checkNumberOfIssuesTest() {
        CredentialsManager credentialsManager = ConfigCache.getOrCreate(CredentialsManager.class);

        Selenide.open(credentialsManager.url());
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(credentialsManager.username(), credentialsManager.password());


        JiraHeader jiraHeaderComponent = new JiraHeader();
        jiraHeaderComponent.openProjectsDashboard();


        JiraProjects jiraProjectsPage = new JiraProjects();
        jiraProjectsPage.getTestProjectLink().click();

        JiraProject jiraProjectPage = new JiraProject();
        int numberOfIssues = jiraProjectPage.getNumberOfIssues();

        jiraHeaderComponent.getCreateIssueButton().click();

        IssueCreationForm issueCreationForm = new IssueCreationForm();
        issueCreationForm.createIssue("Counter issue", "Issue to count issues");
        Selenide.sleep(2000);
        Selenide.refresh();
        Selenide.sleep(2000);
        assertEquals(numberOfIssues + 1, jiraProjectPage.getNumberOfIssues(), "Number of issues is incorrect");
    }

    @Test
    @DisplayName("Проверка задачи SeleniumATHomeworkTaskTest")
    public void checkTestSeleniumATHomeworkTaskTest() {
        CredentialsManager credentialsManager = ConfigCache.getOrCreate(CredentialsManager.class);

        Selenide.open(credentialsManager.url());
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(credentialsManager.username(), credentialsManager.password());


        JiraHeader jiraHeaderComponent = new JiraHeader();
        jiraHeaderComponent.openProjectsDashboard();


        JiraProjects jiraProjectsPage = new JiraProjects();
        jiraProjectsPage.getTestProjectLink().click();

        jiraHeaderComponent.openTaskByQuickSearch("TestSeleniumATHomework");

        JiraTask jiraTaskPage = new JiraTask();

        assertEquals("СДЕЛАТЬ", jiraTaskPage.getTaskStatus(), "Task status is incorrect");
        assertEquals("Version 2.0", jiraTaskPage.getFixVersion(), "Fix version is incorrect");
    }

    @Test
    @DisplayName("Проверка провода задачи по этапам выполнения")
    public void checkTaskFullProcessingTest() {
        CredentialsManager credentialsManager = ConfigCache.getOrCreate(CredentialsManager.class);

        Selenide.open(credentialsManager.url());
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(credentialsManager.username(), credentialsManager.password());


        JiraHeader jiraHeaderComponent = new JiraHeader();
        jiraHeaderComponent.openProjectsDashboard();


        JiraProjects jiraProjectsPage = new JiraProjects();
        jiraProjectsPage.getTestProjectLink().click();

        jiraHeaderComponent.getCreateIssueButton().click();

        IssueCreationForm issueCreationForm = new IssueCreationForm();
        issueCreationForm.createIssue("FullTestIssue", "Issue to move through full processing");

        JiraProject jiraProjectPage = new JiraProject();
        jiraProjectPage.getCreatedIssueLink().click();

        JiraTask jiraTaskPage = new JiraTask();
        jiraTaskPage.moveTaskToInProgress();
        Selenide.sleep(2000);
        jiraTaskPage.getTaskProcess().click();
        Selenide.sleep(2000);
        jiraTaskPage.getTaskDoneSelection().click();
        Selenide.sleep(2000);
        assertEquals("ГОТОВО", jiraTaskPage.getTaskStatus(), "Task status is incorrect");

    }
}