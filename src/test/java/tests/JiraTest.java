package tests;

import com.codeborne.selenide.Selenide;
import hooks.WebHook;
import components.IssueCreationForm;
import components.JiraHeader;
import pages.JiraProject;
import pages.JiraProjects;
import pages.JiraStartPage;
import pages.JiraTask;
import utils.CredentialsManager;
import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JiraTest extends WebHook {

    @Test
    public void loginTest() {

        CredentialsManager credentialsManager = ConfigCache.getOrCreate(CredentialsManager.class);

        Selenide.open(credentialsManager.url());
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(credentialsManager.username(), credentialsManager.password());

        JiraHeader jiraHeaderComponent = new JiraHeader();
        assertTrue(jiraHeaderComponent.logoutButtonExists(), "Login failed");

    }



    @Test
    public void moveToProjectTest() {
        CredentialsManager credentialsManager = ConfigCache.getOrCreate(CredentialsManager.class);

        Selenide.open(credentialsManager.url());
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.login(credentialsManager.username(), credentialsManager.password());


        JiraHeader jiraHeaderComponent = new JiraHeader();
        jiraHeaderComponent.openProjectsDashboard();


        JiraProjects jiraProjectsPage = new JiraProjects();
        jiraProjectsPage.getTestProjectLink().click();

        JiraProject jiraProjectPage = new JiraProject();
        assertEquals("Test", jiraProjectPage.getProjectName());
    }

    @Test
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