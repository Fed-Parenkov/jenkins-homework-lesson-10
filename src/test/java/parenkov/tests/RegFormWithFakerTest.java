package parenkov.tests;

import org.junit.jupiter.api.Test;
import parenkov.pages.RegFormWithFakerPage;

import static com.codeborne.selenide.Selenide.open;
import static parenkov.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class RegFormWithFakerTest extends TestBase{

    RegFormWithFakerPage regFormPage = new RegFormWithFakerPage();

    @Test
    void FillRegFormTest() {

        step("Открыть страницу с формой на https://demoqa.com/", () -> {
            regFormPage.openPage();
        });
        step("Ввести First Name", () -> {
            regFormPage.typeFirstName();
        });
        step("Ввести Last Name", () -> {
            regFormPage.typeLastName();
        });
        step("Ввести Email", () -> {
            regFormPage.typeEmail();
        });
        step("Выбрать пол", () -> {
            regFormPage.selectGender(gender);
        });
        step("Ввести мобильный номер", () -> {
            regFormPage.typeMobileNumber();
        });
        step("Выбрать Subject", () -> {
            regFormPage.typeSubject(subject);
        });
        step("Выбрать хобби", () -> {
            regFormPage.selectHobbies(hobbies);
        });
        step("Загрузить картинку", () -> {
            regFormPage.uploadPicture();
        });
        step("Установить дату рождения", () -> {
            regFormPage.calendar.setDateOfBirth(day, month, year);
        });
        step("Скролл страницы вниз", () -> {
            regFormPage.scrollPage();
        });
        step("Ввести Current Address", () -> {
            regFormPage.typeCurrentAddress();
        });
        step("Ввести State", () -> {
            regFormPage.typeState();
        });
        step("Ввести City", () -> {
            regFormPage.typeCity();
        });
        step("Нажать кнопку Submit", () -> {
            regFormPage.clickSubmit();
        });
        step("Проверить соответствие введенных данных в модальном окне", () -> {
            regFormPage.checkModalWindow();
        });


//        regFormPage.typeFirstName()
//                .typeLastName()
//                .typeEmail()
//                .selectGender(gender)
//                .typeMobileNumber()
//                .typeSubject(subject)
//                .selectHobbies(hobbies)
//                .uploadPicture();
//        regFormPage.calendar.setDateOfBirth(day, month, year);
//        regFormPage.scrollPage();
//        regFormPage.typeCurrentAddress()
//                .typeState()
//                .typeCity();
//        regFormPage.clickSubmit();
//        regFormPage.checkModalWindow();
    }
}
