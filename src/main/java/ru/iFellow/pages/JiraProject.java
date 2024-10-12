package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница проекта в Jira
 * @author Fedor Zlobin
 */
public class JiraProject {
    private final SelenideElement projectName = $x("//div[@class='aui-page-header-main']//div[@class='aui-item project-title']/a").as("Имя проекта");
    private final SelenideElement numberOfIssues = $x("//div[@class='issue-tools']//div[@class='showing']/span").as("Количество задач");
    private final SelenideElement createdIssueLink  = $x("//a[@class='issue-created-key issue-link']").as("Ссылка на созданную задачу");

    /**
     * Получить имя проекта
     * @return <code>String</code> - имя проекта
     */
    public String getProjectName() {
        return projectName.shouldBe(Condition.visible).getText();
    }

    /**
     * Получить количество задач
     * @return <code>int</code> - количество задач
     */
    public int getNumberOfIssues() {
        return Integer.parseInt(numberOfIssues.shouldBe(Condition.visible).getText().replaceAll("1 из ",""));
    }

    /**
     * Получить элемент счетчика задач в проекте
     * @return <code>SelenideElement</code> - элемент счетчика задач в проекте
     */
    public SelenideElement getNumberOfIssuesElement() {
        return numberOfIssues;
    }

    /**
     * Получить ссылку на созданную задачу
     * @return <code>SelenideElement</code> - ссылка на созданную задачу
     */
    public SelenideElement getCreatedIssueLink() {
        return createdIssueLink.shouldBe(Condition.visible);
    }

}
