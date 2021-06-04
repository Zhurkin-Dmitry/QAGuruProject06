package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем сайт Github {github}")
    public void openGithub(String github) {
        open(github);
    }

    @Step("Поиск репозитория {headerSearch}, {repository}")
    public void searchRepository(String headerSearch, String repository) {
        $(headerSearch).click();
        $(headerSearch).sendKeys(repository);
        $(headerSearch).submit();
    }

    @Step("Переходим к репозиторию {repository}")
    public void openRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Открытие Issues")
    public void openIssues() {
        $(withText("Issues")).click();
    }

    @Step("Проверка существования Issue №68 {issueNumber}")
    public void searchNum68Repository(int issueNumber) {
        $(withText("#" + 68)).should(Condition.exist);
    }

}
