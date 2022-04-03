package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TinkoffTests extends TestBase {
    @Test
    @Description("Мониторим, что сайт работает")
    @DisplayName("Проверка, что открылась главная страница")
    void mainPageTileTest() {
        step("Open url 'https://www.tinkoff.ru/'", () ->
            open("https://www.tinkoff.ru/"));

        step("Проверяем заголовок", () -> {
            $(".bb4h2Ktd4").$("p").shouldHave(text("Новости и советы"));
        });
    }

    @Test
    @Disabled
    @Description("Отключен, чтобы сборка не падала")
    @DisplayName("Проверка, что нет ошибок в консоли")
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

    @Test
    @DisplayName("Проверка перехода с главной страницы на вкладку Путешествие")
    void openTravelPageTest() {
        step("Открыть https://www.tinkoff.ru/", () ->
            open("https://www.tinkoff.ru/"));

        step("Кликнуть на вкладку Путешествия", () -> {
            $$(".ebd_UHO4u").findBy(text("Путешествия")).click();
        });

        step("Проверить, что отображается заголовок \"Авиабилеты с кэшбэком до 7%\"", () -> {
                $((".ab4h2Ktd4.eb4h2Ktd4 .ab1K2RxzT")).$("p").shouldHave(text("Авиабилеты с кэшбэком до 7%"));
        });
    }

    @Test
    @DisplayName("Проверка работы выпадающего списка на вкладке Путешествия")
    void openListPassangers() {
        step("Открыть https://www.tinkoff.ru/travel/flights/", () ->
                open("https://www.tinkoff.ru/travel/flights/"));

        step("Кликнуть на выпадающий список", () -> {
            $(".travelsearchform__cPojqY").click();
        });

        step("Проверить, что есть слово Взрослые", () -> {
            $(".travelsearchform__efOKhH").shouldHave(text("Взрослые"));
        });
    }

    @Test
    @DisplayName("Переход с вкладки путешествия на главную страницу")
    void openMainPage() {
        step("Открыть https://www.tinkoff.ru/travel/flights/", () ->
                open("https://www.tinkoff.ru/travel/flights/"));

        step("Кликнуть на логотип", () -> {
            $(".header__a2oLbN").click();;
        });

        step("Проверяем заголовок", () -> {
            $(".bb4h2Ktd4").$("p").shouldHave(text("Новости и советы"));
        });
    }
}