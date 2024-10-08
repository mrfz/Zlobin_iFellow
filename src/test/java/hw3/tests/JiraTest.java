package hw3.tests;

import hw3.Hooks.WebHook;
import hw3.steps.*;
import hw3.utils.TestDataManager;
import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        LoginSteps loginSteps = new LoginSteps();
        MoveToProjectSteps moveToProjectSteps = new MoveToProjectSteps();
        CheckNumberOfIssuesSteps checkNumberOfIssuesSteps = new CheckNumberOfIssuesSteps();
        CommonSteps commonSteps = new CommonSteps();
        MoveIssueThroughStagesSteps moveIssue = new MoveIssueThroughStagesSteps();
        SearchTaskByNameSteps searchTaskByNameSteps = new SearchTaskByNameSteps();
        TestDataManager testData = ConfigCache.getOrCreate(TestDataManager.class);



        loginSteps.browserOpen();
        loginSteps.login();
        loginSteps.pressSubmitButton();

        moveToProjectSteps.openProjectsDashboard();
        moveToProjectSteps.clickOnTestProject();

        checkNumberOfIssuesSteps.saveNumberOfIssues();
        checkNumberOfIssuesSteps.callCreateIssueForm();
        commonSteps.fillTask("Counter issue", "Issue to count issues");

        moveIssue.openTask();
        moveIssue.moveIssueToInProgress();
        searchTaskByNameSteps.checkTaskStatus("СДЕЛАТЬ");
        moveIssue.openContextMenuBusinessProcess();
        moveIssue.moveIssueToDone();
        commonSteps.updatePage();

        searchTaskByNameSteps.checkTaskStatus(testData.taskToProcessStatus());
    }
}