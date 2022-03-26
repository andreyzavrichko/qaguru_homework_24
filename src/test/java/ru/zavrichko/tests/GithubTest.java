package ru.zavrichko.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GithubTest extends TestBase {
    @Test
    public void testChipsRoadmapSearch() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажимаем на пункт Roadmap в нижнем меню", () -> {
            $(linkText("Roadmap")).click();
        });
        step("Проверяем наличие Chips github github-enterprise roadmap", () -> {
            $(partialLinkText("github")).should(Condition.visible);
            $(partialLinkText("github-enterprise")).should(Condition.visible);
            $(partialLinkText("roadmap")).should(Condition.visible);
        });
    }

    @Test
    public void testChipsFreeAppsSearch() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажать на ссылку Marketplace в меню", () -> {
            $(linkText("Marketplace")).click();
        });
        step("Нажать на кнопку Explore free apps", () -> {
            $(linkText("Explore free apps")).click();
        });
        step("Проверить отображение Chips Free в результатах фильтра", () -> {
            $x("//span[@class='topic-tag-action f6']").should(Condition.visible);
        });
    }

    @Test
    public void testGetStartedSearch() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажать на пункт Docs в нижнем меню", () -> {
            $(linkText("Docs")).click();
        });
        step("Нажать на ссылку Get started", () -> {
            $(linkText("Get started")).click();
        });
        step("Нажать на кнопку Quickstart", () -> {
            $(linkText("Quickstart")).click();
        });
        step("Проверить наличие списка", () -> {
            $x("//ul[@class='list-style-outside pl-2']").should(Condition.visible);
        });
    }

    @Test
    public void testButtonSignUpSearch() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Проверить наличие кнопки Sign up for GitHub", () -> {
            $x("//button[@type='submit']").should(Condition.visible);
        });
    }

    @Test
    public void testGameEnginesCollectionsSearch() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Нажать на ссылку Explore в меню", () -> {
            $x("//summary[text()[normalize-space()='Explore']]").hover();
        });
        step("Выбрать пункт Collections", () -> {
            $(linkText("Collections")).click();
        });
        step("Нажать на блок Game Engines", () -> {
            $(partialLinkText("Game Engines")).click();
        });
        step("Проверить отображение коллекций", () -> {
            $x("//div[contains(@class,'pt-md-6 pb-3')]").should(Condition.visible);
        });
    }

    @Test
    public void testSelenoidPostSearch() {
        step("Перейти на главную страницу", () -> {
            open(baseUrl);
        });
        step("Открываем пункт меню Explore", () -> {
            $x("//summary[text()[normalize-space()='Explore']]").hover();
        });
        step("Переходим по ссылке Community forum", () -> {
            $(linkText("Community forum")).click();
        });
        step("В окно поиска вводим selenoid", () -> {
            $("#search-term").click();
            $("#search-term").sendKeys("selenoid");
            $x("//a[@href='#']").click();
        });
        step("Проверяем наличие выпадающего меню Go grid router(ggr) docker with selenoid", () -> {
            $x("//a[@class='widget-link search-link']").should(Condition.visible);
        });
    }


}
