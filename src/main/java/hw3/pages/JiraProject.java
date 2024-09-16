package hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraProject {
    private final SelenideElement projectName = $x("//div[@class='aui-page-header-main']//div[@class='aui-item project-title']/a");
    private final SelenideElement numberOfIssues = $x("//div[@class='issue-tools']//div[@class='showing']/span");

    public String getProjectName() {
        return projectName.shouldBe(Condition.visible).getText();
    }

    public int getNumberOfIssues() {
        return Integer.parseInt(numberOfIssues.shouldBe(Condition.visible).getText().replaceAll("1 из ",""));
    }


}
