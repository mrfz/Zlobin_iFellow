package hw3.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IssueCreationForm {
    private final SelenideElement issueForm = $x("//section[@id='create-issue-dialog']");
    private final SelenideElement issueTitle = issueForm.$x(".//input[@id='summary']");
    private final SelenideElement issueDescription = issueForm.$x(".//textarea[@id='description']");
    private final SelenideElement issueFixInVersion = issueForm.$x(".//select[@name='fixVersions']//option[contains(text(),'Version 2.0')]");
    private final SelenideElement issueSubmitButton = issueForm.$x(".//input[@id='create-issue-submit']");

    public void createIssue(String title, String description) {
        issueForm.shouldBe(Condition.visible);
        issueTitle.setValue(title);
        issueDescription.setValue(description);
        issueFixInVersion.click();
        issueSubmitButton.click();
    }

}
