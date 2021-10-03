package parenkov.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import parenkov.pages.components.Calendar;
import parenkov.tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static parenkov.tests.TestData.*;

public class RegFormWithFakerPage {
    private SelenideElement firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            EmailField = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            mobileNumberField = $("#userNumber"),
            subjectField = $("#subjectsInput"),
            hobbiesRadioButton = $("#hobbiesWrapper"),
            currentAddressField = $("#currentAddress"),
            uploadButton = $("#uploadPicture"),
            stateField = $("#stateCity-wrapper").$(byText("Select State")),
            cityField = $("#stateCity-wrapper").$(byText("Select City")),
            submitButton = $("#submit");


    public Calendar calendar = new Calendar();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String mobileNumber = faker.number().digits(10);
    String address = faker.address().streetAddress();


    public void scrollPage() {
        $("#submit").scrollIntoView(true);
    }
    public void openPage() {
        open("https://demoqa.com/" + url);
    }


    public RegFormWithFakerPage typeFirstName() {
        firstNameField.setValue(firstName);
        return this;
    }

    public RegFormWithFakerPage typeLastName() {
        lastNameField.setValue(lastName);
        return this;
    }

    public RegFormWithFakerPage typeEmail() {
        EmailField.setValue(email);
        return this;
    }

    public RegFormWithFakerPage selectGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegFormWithFakerPage typeMobileNumber() {
        mobileNumberField.setValue(mobileNumber);
        return this;
    }

    public RegFormWithFakerPage typeSubject(String value) {
        subjectField.setValue(value).pressEnter();
        return this;
    }

    public RegFormWithFakerPage selectHobbies(String value) {
        hobbiesRadioButton.$(byText(value)).click();
        return this;
    }

    public RegFormWithFakerPage uploadPicture() {
        uploadButton.uploadFromClasspath(picturePath);
        return this;
    }

    public RegFormWithFakerPage typeState() {
        stateField.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegFormWithFakerPage typeCity() {
        cityField.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegFormWithFakerPage typeCurrentAddress() {
        currentAddressField.setValue(address);
        return this;
    }

    public RegFormWithFakerPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegFormWithFakerPage checkModalWindow() {
        $("#example-modal-sizes-title-lg").shouldHave(text(TestData.modalTitle));
        $(".modal-body").shouldHave(text(firstName + " " + lastName), text(email), text(TestData.gender),
                text(mobileNumber), text(TestData.dateOfBirth), text(TestData.subject), text(TestData.hobbies),
                text(TestData.picture), text(address), text(state + " " + TestData.city));
        return this;
    }
}
