package tests;

import dto.Student;
import enums.Gender;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest() {
        Student student = new Student("rupi", "kaur",
                "milkandhoney@poet.com", Gender.FEMALE,
                "919876543210", "04 Apr 1992", "English,Arts",
                "Reading", "", "Lane 3, Overthinking Colony", "NCR", "Delhi");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).inputStudentRegForm(student);
    }
}
