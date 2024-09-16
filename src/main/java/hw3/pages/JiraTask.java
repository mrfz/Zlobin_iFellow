package hw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTask {
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/span");
    private final SelenideElement taskFixVersion = $x("//span[@id='fixVersions-field']/a");

    public String getTaskStatus() {
        return taskStatus.getText();
    }

    public String getFixVersion() {
        return taskFixVersion.getText();
    }
}
