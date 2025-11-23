package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeAll
    static void setupEnvironment() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
    }

    @BeforeEach
    void addSelenideLogger() {
        SelenideLogger.addListener("allure",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
