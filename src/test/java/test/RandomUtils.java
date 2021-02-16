package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class RandomUtils {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillFormTest() {
        String firstName = getRandomString(10),
                lastName = getRandomString(10),
                email = getRandomEmail(),
                gender = "Other",
                mobile = getRandomPhone(),
                dayOfBirth = "10",
                monthOfBirth = "May",
                yearOfBirth = "1988",
                subject1 = "Chemistry",
                subject2 = "Commerce",
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                picture = "Untitled2.png",
                currentAddress = getRandomMessage(30, 100),
                state = "Uttar Pradesh",
                city = "Merrut";

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $(byText(gender)).click();
        $("#userNumber").val(mobile);
        // set date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        // set subject
        $("#subjectsInput").val(subject1);
        $$(byText(subject1)).last().click();
        $("#subjectsInput").val(subject2);
        $$(byText(subject2)).last().click();
        // set hobbies
        $$(byText(hobby1)).last().click();
        $$(byText(hobby2)).last().click();
        $$(byText(hobby3)).last().click();
        // upload image
//        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));
        $("#uploadPicture").uploadFromClasspath(picture);
        // set current address
        $("#currentAddress").val(currentAddress);
        // set state and city
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        $("#submit").click();
        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(mobile),
                text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text(subject1 + ", " + subject2),
                text(hobby1 + ", " + hobby2 + ", " + hobby3),
                text(picture),
                text(currentAddress),
                text(state + " " + city));
    }
}
