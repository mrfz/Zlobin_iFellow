package hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraProject {
    private final SelenideElement projectName = $x("//div[@class='aui-page-header-main']//div[@class='aui-item project-title']/a");

    public String getProjectName() {
        return projectName.shouldBe(Condition.visible).getText();
    }
}
