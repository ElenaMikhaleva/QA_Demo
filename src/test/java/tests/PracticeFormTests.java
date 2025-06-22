package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        Student student = new Student("rupi", "kaur",
                "milkandhoney@poet.com", Gender.FEMALE,
                "919876543210", "04 Apr 1992", "English,Arts",
                hobbies, "", "Lane 3, Overthinking Colony", StateCity.HARYANA.getState(),
                StateCity.HARYANA.getCity()[1]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).inputStudentRegForm(student);
        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage());
    }
}
