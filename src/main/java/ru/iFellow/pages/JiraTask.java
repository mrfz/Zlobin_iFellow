package ru.iFellow.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTask {
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/span");
    private final SelenideElement taskFixVersion = $x("//span[@id='fixVersions-field']/a");
    private final SelenideElement taskInProgress = $x("//span[@class='trigger-label' and contains(text(), 'В работе')]");
    private final SelenideElement taskProcess = $x("//span[@class='dropdown-text' and contains(text(), 'Бизнес-процесс')]");
    private final SelenideElement taskDoneSelection = $x("//aui-dropdown-menu[@id='opsbar-transitions_more_drop']//span[contains(text(), 'Выполнено')]/parent::a/parent::aui-item-link");

    public String getTaskStatus() {
        return taskStatus.getText();
    }

    public String getFixVersion() {
        return taskFixVersion.getText();
    }

    public void moveTaskToInProgress() {
        taskInProgress.click();
    }


    public SelenideElement getTaskProcess() {
        return taskProcess;
    }

    public SelenideElement getTaskDoneSelection() {
        return taskDoneSelection;
    }


}
