package com.example.demo1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.headless = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");
    }

    @Test
    public void search() {
        mainPage.searchButton.click();
        mainPage.searchInput.sendKeys("heeeeeej");
        $(".quick-search__results-query").shouldHave(ownText("heeeeeej"));
    }
//
//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.hover();
//
//        $(".menu-main__popup-wrapper").shouldBe(visible);
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeAllToolsButton.click();
//
//        $(".products-list").shouldBe(visible);
//
//        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
//    }
}
