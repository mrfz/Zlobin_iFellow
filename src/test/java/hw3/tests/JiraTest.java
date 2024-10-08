package hw3.tests;

import com.codeborne.selenide.Selenide;
import hw3.Hooks.WebHook;
import hw3.components.IssueCreationForm;
import hw3.components.JiraHeader;
import hw3.pages.JiraProject;
import hw3.pages.JiraProjects;
import hw3.pages.JiraStartPage;
import hw3.pages.JiraTask;
import hw3.steps.*;
import hw3.utils.CredentialsManager;
import hw3.utils.TestDataManager;
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
        LoginSteps loginSteps = new LoginSteps();
        MoveToProjectSteps moveToProjectSteps = new MoveToProjectSteps();
        CheckNumberOfIssuesSteps checkNumberOfIssuesSteps = new CheckNumberOfIssuesSteps();
        CommonSteps commonSteps = new CommonSteps();


        loginSteps.browserOpen();
        loginSteps.login();
        loginSteps.pressSubmitButton();

        moveToProjectSteps.openProjectsDashboard();
        moveToProjectSteps.clickOnTestProject();

        checkNumberOfIssuesSteps.saveNumberOfIssues();
        checkNumberOfIssuesSteps.callCreateIssueForm();
        commonSteps.fillTask("Counter issue", "Issue to count issues");
        commonSteps.updatePage();
        checkNumberOfIssuesSteps.checkNumberOfIssues();

    }

    @Test
    @DisplayName("Проверка задачи SeleniumATHomeworkTaskTest")
    public void checkTestSeleniumATHomeworkTaskTest() {
        LoginSteps loginSteps = new LoginSteps();
        MoveToProjectSteps moveToProjectSteps = new MoveToProjectSteps();
        SearchTaskByNameSteps searchTaskByNameSteps = new SearchTaskByNameSteps();
        TestDataManager testData = ConfigCache.getOrCreate(TestDataManager.class);


        loginSteps.browserOpen();
        loginSteps.login();
        loginSteps.pressSubmitButton();

        moveToProjectSteps.openProjectsDashboard();
        moveToProjectSteps.clickOnTestProject();

        searchTaskByNameSteps.fillQuickSearch(testData.taskToSearchName());
        searchTaskByNameSteps.openTask(testData.taskToSearchName());
        searchTaskByNameSteps.checkFixIn(testData.taskToSearchVersion());
        searchTaskByNameSteps.checkTaskStatus(testData.taskToSearchStatus());


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