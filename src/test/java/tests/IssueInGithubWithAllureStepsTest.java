package tests;

import allureSteps.IssueInGithubSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты работы с Issue в Github (аллюр-степы)")
public class IssueInGithubWithAllureStepsTest extends TestBase {

    IssueInGithubSteps steps = new IssueInGithubSteps();

    @Test
    @DisplayName("Аллюр степы")
    @Feature("Поиск issue в репозитории")
    @Story("Поиск issue 1")
    public void issueSearchTest() {
        steps.openPage();
        steps.clickIssueTab();
        steps.checkIssueNumber();
        steps.checkIssueTitle();
    }
}
