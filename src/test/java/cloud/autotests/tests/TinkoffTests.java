package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TinkoffTests extends TestBase {
    @Test
    @Disabled
    @DisplayName("Проверка перехода с главной страницы на вкладку Путешествие")
    void generatedTest() {
        step("Открыть https://www.tinkoff.ru/", () -> {
            step("// todo: just add selenium action");
        });

        step("Кликнуть на вкладку Путешествия", () -> {
            step("// todo: just add selenium action");
        });

        step("Проверить, что отображается заголовок \"Авиабилеты с кэшбэком до 7%\"", () -> {
            step("// todo: just add selenium action");
        });
    }

    @Test
    @Disabled
    @Description("монитиорим, что сайт работает")
    @DisplayName("Проверка, что открылась главная страница")
    void titleTest() {
        step("Open url 'https://www.tinkoff.ru/'", () ->
            open("https://www.tinkoff.ru/"));

        step("Page title should have text 'Тинькофф — Кредитные и дебетовые карты, кредиты для бизнеса и физических лиц'", () -> {
            String expectedTitle = "Тинькофф — Кредитные и дебетовые карты, кредиты для бизнеса и физических лиц";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Disabled
    @Description("проверяем фронтовые ошибки")
    @DisplayName("Проверка, что не ошибок в консоли")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.tinkoff.ru/'", () ->
            open("https://www.tinkoff.ru/"));

        step("Логи в консоли не содержат текста 'SEVERE'", () -> {
            //метод, который забирает логи из консоли
            String consoleLogs = DriverUtils.getConsoleLogs();
            // все ошибки в консоли начинаются с этого слова
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}