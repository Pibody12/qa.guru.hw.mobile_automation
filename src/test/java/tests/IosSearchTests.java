package tests;

import base.TestBaseIos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class IosSearchTests extends TestBaseIos {

    @Test
    @DisplayName("Проверка перехода по кнопке Text")
    void successfulSearchIosTest() {

        step("Нажать кнопку Text", () -> {
            $(accessibilityId("Text")).click();
        });

        step("Проверка кнопку текста на экране", () -> {
            $(accessibilityId("Text Output")).shouldBe(visible)
                    .shouldHave(text("Waiting for text input."));
        });
    }
}