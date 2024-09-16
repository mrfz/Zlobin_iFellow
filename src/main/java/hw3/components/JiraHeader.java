package hw3.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraHeader {
    private final SelenideElement userOptions = $x("//li[@id='user-options']");
    private final SelenideElement logoutButton = $x("//li[@id='user-options']//a[@id='log_out']");
    private final SelenideElement projectsMenu = $x("//ul[@class='aui-nav']//a[text()='Проекты']");
    private final SelenideElement allProjectsLink = $x("//ul[@class='aui-nav']//a[@id='project_view_all_link_lnk']");
    private final SelenideElement createIssueButton = $x("//ul[@class='aui-nav']//a[text()='Создать']");

    public boolean logoutButtonExists() {
        return logoutButton.shouldBe(Condition.exist).exists();
    }

    public SelenideElement getLogoutButton() {
        return logoutButton.shouldBe(Condition.visible);
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

}
