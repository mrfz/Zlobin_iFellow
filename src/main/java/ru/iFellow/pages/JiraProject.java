package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraProject {
    private final SelenideElement projectName = $x("//div[@class='aui-page-header-main']//div[@class='aui-item project-title']/a").as("Имя проекта");
    private final SelenideElement numberOfIssues = $x("//div[@class='issue-tools']//div[@class='showing']/span").as("Количество задач");
    private final SelenideElement createdIssueLink  = $x("//a[@class='issue-created-key issue-link']").as("Ссылка на созданную задачу");

    public String getProjectName() {
        return projectName.shouldBe(Condition.visible).getText();
    }

    public int getNumberOfIssues() {
        return Integer.parseInt(numberOfIssues.shouldBe(Condition.visible).getText().replaceAll("1 из ",""));
    }

    public SelenideElement getNumberOfIssuesElement() {
        return numberOfIssues;
    }

    public SelenideElement getCreatedIssueLink() {
        return createdIssueLink.shouldBe(Condition.visible);
    }

}
