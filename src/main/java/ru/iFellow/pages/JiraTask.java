package ru.iFellow.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница задачи в Jira
 * @author Fedor Zlobin
 */
public class JiraTask {
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/span").as("Статус задачи");
    private final SelenideElement taskFixVersion = $x("//span[@id='fixVersions-field']/a").as("Исправить в версии");
    private final SelenideElement taskInProgress = $x("//span[@class='trigger-label' and contains(text(), 'В работе')]").as("Задача в работе");
    private final SelenideElement taskProcess = $x("//span[@class='dropdown-text' and contains(text(), 'Бизнес-процесс')]").as("Бизнес-процесс задачи");
    private final SelenideElement taskDoneSelection = $x("//aui-dropdown-menu[@id='opsbar-transitions_more_drop']//span[contains(text(), 'Выполнено')]/parent::a/parent::aui-item-link").as("Завершение задачи");

    /**
     * Получить элемент статуса задачи
     * @return <code>SelenideElement</code> - элемент статуса задачи
     */
    public SelenideElement getTaskStatus() {
        return taskStatus;
    }

    /**
     * Получить элемент исправить в версии задачи
     * @return <code>SelenideElement</code> - элемент исправить в версии задачи
     */
    public String getFixVersion() {
        return taskFixVersion.getText();
    }

    /**
     * Перевести задачу в работу
     */
    public void moveTaskToInProgress() {
        taskInProgress.click();
    }

    /**
     * Получить элемент кнопки бизнес-процесса задачи
     * @return <code>SelenideElement</code> - элемент кнопки бизнес-процесса задачи
     */
    public SelenideElement getTaskProcess() {
        return taskProcess;
    }

    /**
     * Получить элемент кнопки завершения задачи
     * выполняется проверка видимости элемента с задержкой 3 секунды
     * @return <code>SelenideElement</code> - элемент кнопки завершения задачи
     */
    public SelenideElement getTaskDoneSelection() {
        return taskDoneSelection.shouldBe(Condition.visible, Duration.ofSeconds(3));
    }


}
