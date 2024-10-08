package hw3.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraHeader {
    private final SelenideElement navBarPrimary = $x("//div[@class='aui-header-primary']").as("Основная навигационная панель");
    private final SelenideElement navBarSecondary = $x("//div[@class='aui-header-secondary']").as("Вспомогательная навигационная панель");
    private final SelenideElement userOptions = $x("//li[@id='user-options']").as("Пользовательские настройки");
    private final SelenideElement logoutButton = $x("//li[@id='user-options']//a[@id='log_out']").as("Кнопка выхода");
    private final SelenideElement projectsMenu = navBarPrimary.$x(".//a[text()='Проекты']").as("Меню проектов");
    private final SelenideElement allProjectsLink = navBarPrimary.$x(".//a[@id='project_view_all_link_lnk']").as("Ссылка на все проекты");
    private final SelenideElement createIssueButton = navBarPrimary.$x(".//a[text()='Создать']").as("Кнопка создания задачи");
    private final SelenideElement fieldQuickSearch = navBarSecondary.$x(".//input[@id='quickSearchInput']").as("Поле быстрого поиска");
    private final SelenideElement searchDropdownResults = navBarSecondary.$x(".//div[@class='quicksearch-dropdown']").as("Результаты поиска");


    public SelenideElement logoutButtonExists() {
        return logoutButton.shouldBe(Condition.exist);
    }

    public void openProjectsDashboard() {
        projectsMenu.shouldBe(Condition.visible).click();
        allProjectsLink.shouldBe(Condition.visible).click();
    }

    public SelenideElement getCreateIssueButton() {
        return createIssueButton.shouldBe(Condition.visible);
    }

    public void openTaskByQuickSearch(String field) {
        String fieldXPath = String.format(".//span[@class='quick-search-item-title' and contains(text(),%s)]",field);

        fieldQuickSearch.shouldBe(Condition.visible)
                .setValue(field);
        searchDropdownResults.shouldBe(Condition.visible)
                .$x(fieldXPath)
                .click();

    }



}
