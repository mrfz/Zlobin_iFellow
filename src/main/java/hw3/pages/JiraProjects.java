package hw3.pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class JiraProjects {

    private final SelenideElement testProjectLink = $x("//a[@original-title='Test']").as("Ссылка на тестовый проект");

    public SelenideElement getTestProjectLink() {
        return testProjectLink;
    }
}
