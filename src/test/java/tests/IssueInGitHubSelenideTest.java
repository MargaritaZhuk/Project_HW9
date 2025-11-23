package tests;

import allureSteps.IssueInGithubSteps;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тест с логгером селенида")
public class IssueInGitHubSelenideTest extends TestBase {

    static {
        SelenideLogger.addListener("allure",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    @DisplayName("Аллюр селенид")
    @Feature("Поиск issue в репозитории")
    @Story("Поиск issue 1")
    void issueInGitHubSelenideLoggerTest() {
        open(IssueInGithubSteps.REPOSITORY);
        IssueInGithubSteps.issueTab.click();
        IssueInGithubSteps.issueNumber.findBy(text(IssueInGithubSteps.issue_number)).should(exist);
        IssueInGithubSteps.issueTitleSelector.shouldHave(exactText(IssueInGithubSteps.issue));
    }
}

