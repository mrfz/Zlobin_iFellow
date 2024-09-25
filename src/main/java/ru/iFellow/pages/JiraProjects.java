package ru.iFellow.pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class JiraProjects {

    private final SelenideElement testProjectLink = $x("//a[@original-title='Test']");

    public SelenideElement getTestProjectLink() {
        return testProjectLink;
    }
}
