package hw3.tests;

import hw3.components.JiraHeader;
import hw3.pages.JiraProject;
import hw3.pages.JiraProjects;
import hw3.pages.JiraStartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import hw3.utils.ConfigurationManager;
import hw3.utils.CredentialsManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JiraTest {

    @BeforeAll
    public static void setUp() {
        ConfigurationManager configurationManager = new ConfigurationManager();
        configurationManager.openOnFullResolution();
    }

    @AfterEach
    public void tearDown() {
        JiraHeader jiraHeaderComponent = new JiraHeader();
        jiraHeaderComponent.logout();
    }

    @Test
    public void loginTest() {

        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.open();
        jiraStartPage.login (CredentialsManager.getUsername(), CredentialsManager.getPassword());

        JiraHeader jiraHeaderComponent = new JiraHeader();
        assertTrue(jiraHeaderComponent.logoutButtonExists(), "Login failed");

    }

    @Test
    public void moveToProjectTest() {
        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.open();
        jiraStartPage.login (CredentialsManager.getUsername(), CredentialsManager.getPassword());


        JiraHeader jiraHeaderComponent = new JiraHeader();
        jiraHeaderComponent.openProjectsDashboard();


        JiraProjects jiraProjectsPage = new JiraProjects();
        jiraProjectsPage.getTestProjectLink().click();

        JiraProject jiraProjectPage = new JiraProject();
        assertEquals("Test", jiraProjectPage.getProjectName());
    }



}