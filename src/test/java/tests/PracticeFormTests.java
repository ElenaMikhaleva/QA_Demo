package tests;

import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest() {
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).inputStudentRegForm("rupi", "kaur",
                "milkandhoney@poet.com", "Female", "919876543210", "04 Apr 1992", "English",
                false, true, false, "Lane 3, Overthinking Colony");
    }
}
