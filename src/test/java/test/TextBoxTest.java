package test;

import com.codeborne.selenide.Configuration;
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
    //DateOfBirth
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
    $(".modal-content").shouldHave(text("Thanks for submmitting the form"),
                                   text("Ilgiz Student"),
                                   text("student@gmail.com"),
                                   text("Male"),
                                   text("1234567890"),
                                   text("25 Febrary,1995"),
                                   text("Computer Science"));
                                   
                                   
    }

}
