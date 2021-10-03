package parenkov.tests;

import org.junit.jupiter.api.Test;
import parenkov.pages.RegFormWithFakerPage;

import static parenkov.tests.TestData.*;

public class RegFormWithFakerTest extends TestBase{

    RegFormWithFakerPage regFormPage = new RegFormWithFakerPage();

    @Test
    void FillRegFormTest() {
        regFormPage.openPage();
        regFormPage.typeFirstName()
                .typeLastName()
                .typeEmail()
                .selectGender(gender)
                .typeMobileNumber()
                .typeSubject(subject)
                .selectHobbies(hobbies)
                .uploadPicture();
        regFormPage.calendar.setDateOfBirth(day, month, year);
        regFormPage.scrollPage();
        regFormPage.typeCurrentAddress()
                .typeStateAndCity();
        regFormPage.clickSubmit();
        regFormPage.checkModalWindow();
    }
}
