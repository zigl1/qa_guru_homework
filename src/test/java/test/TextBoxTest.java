package test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends TestBase {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dataAppearsInOutputBlockTest() {
        //Test data
        Faker faker = new Faker();
        String firstname = faker.name().firstName(),
                lastname = faker.name().lastName(),
                email = faker.internet().emailAddress("test"),
                gender = "Male",
                mobile = faker.phoneNumber().subscriberNumber(10),
                month = "February",
                year = "1995",
                day = "25",
                subject = "Computer Science",
                fileloc = "src/test/resources/Untitled2.png",
                filename = "Untitled2.png",
                address = faker.address().fullAddress(),
                state = "Rajasthan",
                city = "Jaipur";

        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        //DateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day.react-datepicker__day--025").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File(fileloc));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();
        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text(firstname + " " + lastname),
                text(email),
                text(gender),
                text(mobile),
                text(day + " " + month + "," + year),
                text(subject),
                text("Sports"),
                text(filename),
                text(address),
                text(state + " " + city));
    }

}
