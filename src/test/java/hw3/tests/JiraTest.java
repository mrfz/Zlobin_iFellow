package hw3.tests;

import com.codeborne.selenide.Selenide;
import hw3.Hooks.WebHook;
import hw3.components.IssueCreationForm;
import hw3.components.JiraHeader;
import hw3.pages.JiraProject;
import hw3.pages.JiraProjects;
import hw3.pages.JiraStartPage;
import hw3.pages.JiraTask;
import hw3.utils.CredentialsManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JiraTest extends WebHook {

    @Test
    public void loginTest() {
        Selenide.open("https://edujira.ifellow.ru");
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(CredentialsManager.getUsername(), CredentialsManager.getPassword());

        JiraHeader jiraHeaderComponent = new JiraHeader();
        assertTrue(jiraHeaderComponent.logoutButtonExists(), "Login failed");

    }

    @Test
    public void moveToProjectTest() {
        Selenide.open("https://edujira.ifellow.ru");
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(CredentialsManager.getUsername(), CredentialsManager.getPassword());


        JiraHeader jiraHeaderComponent = new JiraHeader();
        jiraHeaderComponent.openProjectsDashboard();


        JiraProjects jiraProjectsPage = new JiraProjects();
        jiraProjectsPage.getTestProjectLink().click();

        JiraProject jiraProjectPage = new JiraProject();
        assertEquals("Test", jiraProjectPage.getProjectName());
    }

    @Test
    public void checkNumberOfIssuesTest() {
        Selenide.open("https://edujira.ifellow.ru");
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(CredentialsManager.getUsername(), CredentialsManager.getPassword());


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
    public void checkTestSeleniumATHomeworkTaskTest() {
        Selenide.open("https://edujira.ifellow.ru");
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(CredentialsManager.getUsername(), CredentialsManager.getPassword());


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
    public void checkTaskFullProcessingTest() {
        Selenide.open("https://edujira.ifellow.ru");
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(CredentialsManager.getUsername(), CredentialsManager.getPassword());


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