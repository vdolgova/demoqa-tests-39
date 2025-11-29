package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
     open("/text-box");
     $("#userName").setValue("Ivan");
     $("#userEmail").setValue("ivan@rt.ru");
     $("#currentAddress").setValue("some street 1");
     $("#permanentAddress").setValue("anover srteet 1");
     $("#submit").click();
     $("#output #name").shouldHave(text("Ivan"));
     $("#output #email").shouldHave(text("ivan@rt.ru"));
     $("#output #currentAddress").shouldHave(text("some street 1"));
     $("#output #permanentAddress").shouldHave(text("anover srteet 1"));
    }

}
