package allureSteps;

import com.codeborne.selenide.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class IssueInGithubSteps {
    public static final String REPOSITORY = "/MargaritaZhuk/Project_HW9";
    public static final String issue = "Test_Issue";
    public static SelenideElement issueTab = $("#issues-tab");
    public static SelenideElement issueTitleSelector = $("a[href='/MargaritaZhuk/Project_HW9/issues/1']");
    public static final String issue_number = "#1";
    public static ElementsCollection issueNumber = $$("[data-testid=list-row-repo-name-and-number]");


    @Step("Открыть страницу")
    public void openPage() {
        open(REPOSITORY);
    }

    @Step("Нажать на таб ISSUE")
    public void clickIssueTab(){
        issueTab.click();
    }

    @Step("Проверить, что есть ISSUE с указанным номером")
    public void checkIssueNumber(){
        issueNumber.findBy(text(issue_number)).should(exist);
    }

    @Step("Проверить, что есть ISSUE с указанным названием")
    public void checkIssueTitle(){
       issueTitleSelector.shouldHave(exactText(issue));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
