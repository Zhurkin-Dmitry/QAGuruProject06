package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GithubIssueTest {

    String github = "https://github.com/",
            headerSearch = ".header-search-input",
            repository = "eroshenkoam/allure-example";
    int issueNumber = 68;

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void issueSelenideTest() {
        //SelenideLogger.addListener("allure", new AllureSelenide());
        open(github);
        $(headerSearch).click();
        $(headerSearch).sendKeys(repository);
        $(headerSearch).submit();
        $(By.linkText(repository)).click();
        $(withText("Issues")).click();
        $(withText("#" + issueNumber)).should(Condition.exist);
    }

    @Test
    void issueLambdaTest() {
        step("Открываем сайт Github", () -> {
            open(github);
        });
        step("Поиск репозитория", () -> {
            $(headerSearch).click();
            $(headerSearch).sendKeys(repository);
            $(headerSearch).submit();
        });
        step("Переходим к репозиторию", () -> {
            $(By.linkText(repository)).click();
        });
        step("Открытие Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Проверка существования Issue №68", () -> {
            $(withText("#" + 68)).should(Condition.exist);
        });
    }

    @Test
    void issueWithAnnotationStep() {

    }

}
