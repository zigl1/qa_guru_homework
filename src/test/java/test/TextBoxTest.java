package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;

    }
    @AfterAll
    static void afterAll() {
        Configuration.timeout = 6000;
    }

    @Test
    void dataAppearsInOutputBlockTest() {
    String name ="Ilgiz";
    open("https://demoqa.com/automation-practice-form");
    $(".main-header").shouldHave(text("Practice Form"));
    $("#firstName").setValue(name);
    $("#lastName").setValue("Student");
    $("#userEmail").setValue("student@gmail.com");
    $("label[for='gender-radio-1']").click();
    $("#userNumber").setValue("1234567890");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__year-select").click();
    $("option[value='1995']").click();
    $(".react-datepicker__month-select").click();
    $("option[value='1']").click();
    $(".react-datepicker__day.react-datepicker__day--025").click();
    $("#subjectsInput").setValue("Computer Science").pressEnter();
    $("label[for='hobbies-checkbox-1']").click();
    $("#uploadPicture").setValue("C:\\Users\\ilgiz\\Desktop\\screenshot.test.png");
    $("#currentAddress").setValue("12356 Haha");
    $("#state").click();
    $(By.xpath("//div[contains(text(),'Rajasthan')]")).click();
    $("#city").click();
    $(By.xpath("//div[contains(text(),'Jaipur')]")).click();
    $("#submit").click();
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(By.xpath("//tbody/tr[1]/td[2]")).shouldHave(text(name),text("Student"));
    $("#closeLargeModal").shouldHave(text("Close")).click();



    }


}
