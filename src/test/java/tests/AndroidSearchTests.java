package tests;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {

    @Test
    @DisplayName ("Проверка поиска")
    void successfulSearchTest() {

        step("Ввод поискового запроса", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверка результата поиска", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @DisplayName ("Проверка открытия статьи")
    void successfulSecondSearchTest() {

        step("Ввод поискового запроса", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Открытие статьи", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(text("Appium")).click();
        });

        step("Убедиться, что на странице отображается значок ошибки", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_icon")).should(exist);
        });
    }

//    // Тесты для новой версии Википедия
//    @Test
//    @DisplayName ("Проверка поиска")
//    void successfulSearchForNewVersionWikiTest() {
//
//        step("Переход на страницу поиска", () -> {
//            ((AndroidDriver) getWebDriver())
//                    .pressKey(new KeyEvent(AndroidKey.BACK));
//            $(id("org.wikipedia:id/nav_tab_search")).click();
//            ((AndroidDriver) getWebDriver())
//                    .pressKey(new KeyEvent(AndroidKey.BACK));
//        });
//
//        step("Ввод поискового запроса", () -> {
//            $(id("search_text_view")).click();
//            $(id("org.wikipedia:id/search_src_text")).sendKeys("Appium");
//        });
//
//        step("Проверка результата поиска", () -> {
//        $$(id("org.wikipedia:id/search_lang_button_container"))
//                .shouldHave(sizeGreaterThan(0));
//        });
//    }
//
//    @Test
//    @DisplayName ("Проверка перехода на статью")
//    void successfulSecondSearchForNewVersionWikiTest() {
//
//        step("Переход на страницу поиска", () -> {
//            ((AndroidDriver) getWebDriver())
//                    .pressKey(new KeyEvent(AndroidKey.BACK));
//            $(id("org.wikipedia:id/nav_tab_search")).click();
//            ((AndroidDriver) getWebDriver())
//                .pressKey(new KeyEvent(AndroidKey.BACK));
//        });
//
//        step("Ввод поискового запроса", () -> {
//            $(id("search_text_view")).click();
//            $(id("org.wikipedia:id/search_src_text")).sendKeys("quality assurance");
//        });
//
//        step("Открытие статьи", () -> {
//            $(androidUIAutomator(
//                    "new UiSelector().className(\"android.view.View\").childSelector(new UiSelector().text(\"Quality assurance\"))"
//            )).click();
//        });
//
//        step("Проверка результата поиска", () -> {
//            $$(className("android.webkit.WebView"))
//                    .findBy(text("Quality assurance"))
//                    .shouldBe(visible);
//        });
//    }
}