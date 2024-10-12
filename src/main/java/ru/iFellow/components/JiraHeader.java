package ru.iFellow.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


/**
 * Класс, описывающий навигационную панель
 * @author Fedor Zlobin
 */
public class JiraHeader {
    private final SelenideElement navBarPrimary = $x("//div[@class='aui-header-primary']").as("Основная навигационная панель");
    private final SelenideElement navBarSecondary = $x("//div[@class='aui-header-secondary']").as("Вспомогательная навигационная панель");
    private final SelenideElement logoutButton = $x("//li[@id='user-options']//a[@id='log_out']").as("Кнопка выхода");
    private final SelenideElement projectsMenu = navBarPrimary.$x(".//a[text()='Проекты']").as("Меню проектов");
    private final SelenideElement allProjectsLink = navBarPrimary.$x(".//a[@id='project_view_all_link_lnk']").as("Ссылка на все проекты");
    private final SelenideElement createIssueButton = navBarPrimary.$x(".//a[text()='Создать']").as("Кнопка создания задачи");
    private final SelenideElement fieldQuickSearch = navBarSecondary.$x(".//input[@id='quickSearchInput']").as("Поле быстрого поиска");
    private final SelenideElement searchDropdownResults = navBarSecondary.$x(".//div[@class='quicksearch-dropdown']").as("Результаты поиска");

    /**
     * Проверяет наличие кнопки выхода и возвращает ее
     * @return <code>SelenideElement</code> - кнопка выхода
     */
    public SelenideElement logoutButtonExists() {
        return logoutButton.shouldBe(Condition.exist);
    }

    /**
     * Открывает дашборд проектов
     */
    public void openProjectsDashboard() {
        projectsMenu.shouldBe(Condition.visible).click();
        allProjectsLink.shouldBe(Condition.visible).click();
    }

    /**
     * Проверяет наличие кнопки создания задачи и возвращает ее
     * @return <code>SelenideElement</code> - кнопка создания задачи
     */
    public SelenideElement getCreateIssueButton() {
        return createIssueButton.shouldBe(Condition.visible);
    }

    /**
     * Заполняет поле быстрого поиска
     * @param field текст для поиска
     */
    public void fillQuickSearch(String field) {
        fieldQuickSearch.shouldBe(Condition.visible)
                .setValue(field);
    }

    /**
     * Открывает результаты поиска
     * @param field текст для вызова из результатов поиска
     */
    public void openFoundedByQuickSearch(String field) {
        String fieldXPath = String.format(".//span[@class='quick-search-item-title' and contains(text(),%s)]",field);

        searchDropdownResults.shouldBe(Condition.visible)
                .$x(fieldXPath)
                .click();
    }



}
