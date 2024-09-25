package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Затем;
import pages.JiraTask;

public class MoveIssueThroughStagesSteps {
    JiraTask jiraTaskPage = new JiraTask();

    @Затем("Пользователь переводит задачу в состояние В работе")
    public void moveIssueToInProgress() {
        jiraTaskPage.moveTaskToInProgress();
        Selenide.sleep(2000);
    }


    @Затем("Пользователь вызывает контекстное меню Бизнес-процесс")
    public void openContextMenuBusinessProcess() {
        jiraTaskPage.getTaskProcess().click();
        Selenide.sleep(2000);
    }

    @Затем("Пользователь переводит задачу в состояние Выполнено")
    public void moveTaskToDone() {
        jiraTaskPage.getTaskDoneSelection().click();
        Selenide.sleep(2000);
    }
}
