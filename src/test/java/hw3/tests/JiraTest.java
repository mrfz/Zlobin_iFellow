package hw3.tests;

import hw3.pages.JiraStartPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ConfigurationManager;
import utils.CredentialsManager;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class JiraTest {

    @BeforeAll
    public static void setUp() {
        ConfigurationManager configurationManager = new ConfigurationManager();
        configurationManager.openOnFullResolution();
    }

    @Test
    public void loginTest() {

        JiraStartPage jiraStartPage = new JiraStartPage();
        jiraStartPage.open();
        jiraStartPage.login (CredentialsManager.getUsername(), CredentialsManager.getPassword());
        assertTrue(jiraStartPage.logoutButtonExists(), "Login failed");

    }

}