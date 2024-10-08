package hw3.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class IssueCreationForm {
    private final SelenideElement issueForm = $x("//section[@id='create-issue-dialog']").as("Форма создания задачи");
    private final SelenideElement issueTitle = issueForm.$x(".//input[@id='summary']").as("Название задачи");
    private final SelenideElement issueDescription = issueForm.$x(".//textarea[@id='description']").as("Описание задачи");
    private final SelenideElement issueFixInVersion = issueForm.$x(".//select[@name='fixVersions']//option[contains(text(),'Version 2.0')]").as("Исправление в версии");
    private final SelenideElement issueSubmitButton = issueForm.$x(".//input[@id='create-issue-submit']").as("Кнопка создания задачи");
    private final SelenideElement issuePriority = issueForm.$x(".//div[@id='priority-single-select']/input").as("Приоритет задачи");
    private final SelenideElement issueLabel = issueForm.$x(".//div[@id='labels-multi-select']").as("Теги задачи");
    private final SelenideElement issueVersionAffected = issueForm.$x(".//select[@id='versions']/optgroup/option[contains(text(),'Version 1.0')]").as("Подвергаемые версии");
    private final SelenideElement issueSeverity = issueForm.$x(".//label[contains(text(), 'Серьезность')]/following-sibling::select/option[contains(text(),'S0 Тривиальный/Trivial')]").as("Серьезность задачи");


    public void createIssue(String title, String description) {
        issueForm.shouldBe(Condition.visible);
        issueTitle.setValue(title);
        issueDescription.setValue(description);
        issueFixInVersion.click();
        issuePriority.sendKeys("Highest");
        issueLabel.$x("./textarea").setValue("testLabel");
        issueLabel.$x("./textarea").sendKeys(Keys.ENTER);
        issueVersionAffected.click();
        issueSeverity.click();

        issueSubmitButton.click();
    }

}
