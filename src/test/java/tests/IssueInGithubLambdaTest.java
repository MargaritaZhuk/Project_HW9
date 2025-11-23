package tests;

import allureSteps.IssueInGithubSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Тесты работы с Issue в Github (лямбда)")
public class IssueInGithubLambdaTest extends TestBase {

    IssueInGithubSteps steps = new IssueInGithubSteps();

    @Test
    @DisplayName("Аллюр с лямбдой")
    @Feature("Поиск issue в репозитории")
    @Story("Поиск issue 1")
    void lambdaStepsTest() {
        step("Открыть страницу", () -> {
            steps.openPage();
        });

        step("Нажать на таб ISSUE", () -> {
            steps.clickIssueTab();
        });

        step("Проверить, что есть ISSUE с указанным номером", () -> {
            steps.checkIssueNumber();
        });

        step("Проверить, что есть ISSUE с указанным названием", () -> {
            steps.checkIssueTitle();
            steps.takeScreenshot();
        });
    }
}
