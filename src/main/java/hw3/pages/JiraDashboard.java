package hw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraDashboard {
    private final SelenideElement projectsMenu = $x("//ul[@class='aui-nav']//a[text()='Проекты']");
    private final SelenideElement allProjectsLink = $x("//ul[@class='aui-nav']//a[@id='project_view_all_link_lnk']");

    public void openProjectsDashboard() {
        projectsMenu.click();
        allProjectsLink.click();
    }
}
