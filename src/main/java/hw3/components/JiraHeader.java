package hw3.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraHeader {
    private final SelenideElement navBarPrimary = $x("//div[@class='aui-header-primary']");
    private final SelenideElement navBarSecondary = $x("//div[@class='aui-header-secondary']");
    private final SelenideElement userOptions = $x("//li[@id='user-options']");
    private final SelenideElement logoutButton = $x("//li[@id='user-options']//a[@id='log_out']");
    private final SelenideElement projectsMenu = navBarPrimary.$x(".//a[text()='Проекты']");
    private final SelenideElement allProjectsLink = navBarPrimary.$x(".//a[@id='project_view_all_link_lnk']");
    private final SelenideElement createIssueButton = navBarPrimary.$x(".//a[text()='Создать']");
    private final SelenideElement fieldQuickSearch = navBarSecondary.$x(".//input[@id='quickSearchInput']");
    private final SelenideElement searchDropdownResults = navBarSecondary.$x(".//div[@class='quicksearch-dropdown']");


    public boolean logoutButtonExists() {
        return logoutButton.shouldBe(Condition.exist).exists();
    }

    public void openProjectsDashboard() {
        projectsMenu.shouldBe(Condition.visible).click();
        allProjectsLink.shouldBe(Condition.visible).click();
    }

    public void logout() {
        userOptions.click();
        logoutButton.click();
    }

    public SelenideElement getCreateIssueButton() {
        return createIssueButton.shouldBe(Condition.visible);
    }

    public void openTaskByQuickSearch(String field) {
        String fieldXPath = String.format(".//span[@class='quick-search-item-title' and contains(text(),%s)]",field);

        fieldQuickSearch.shouldBe(Condition.visible)
                .setValue(field);
        searchDropdownResults.shouldBe(Condition.visible)
                .$x(fieldXPath)
                .click();

    }



}
