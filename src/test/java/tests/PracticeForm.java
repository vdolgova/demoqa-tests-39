package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //ввод значений
        $("#firstName").setValue("Vera");
        $("#lastName").setValue("Stepanova");
        $("#userEmail").setValue("v.stepanova@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");

        //дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("March");
        $(".react-datepicker__year-select").selectOptionContainingText("1996");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();

        //ввод subject
        $("#subjectsContainer input").setValue("Arts").pressEnter();

        //выбор хобби
        $("#hobbiesWrapper").$(byText("Music")).click();

        //загрузка изображения
        $("#uploadPicture").uploadFromClasspath("jpegsystems-home.jpg");

        //ввод текущего адреса
        $("#currentAddress").setValue("Lesnaya 15");

        //выбор штата и города
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //отправка формы
        $("#submit").click();

        //проверка формы
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Vera Stepanova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("v.stepanova@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("01 March,1996"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("jpegsystems-home.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Lesnaya 15"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
