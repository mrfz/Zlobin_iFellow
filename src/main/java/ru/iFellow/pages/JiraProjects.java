package ru.iFellow.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Дашборд проектов
 * @author Fedor Zlobin
 */
public class JiraProjects {

    private final SelenideElement testProjectLink = $x("//a[@original-title='Test']").as("Ссылка на тестовый проект");

    /**
     * Получить ссылку на тестовый проект
     * @return <code>SelenideElement</code> - ссылка на тестовый проект
     */
    public SelenideElement getTestProjectLink() {
        return testProjectLink.shouldBe(Condition.visible);
    }
}
