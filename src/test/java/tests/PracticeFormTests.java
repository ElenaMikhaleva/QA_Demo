package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void studentRegFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        Student student = new Student("rupi", "kaur",
                "milkandhoney@poet.com", Gender.FEMALE,
                "9198765432", "04 Apr 1992", "English,Arts",
                hobbies, "", "Lane 3, Overthinking Colony", StateCity.HARYANA.getState(),
                StateCity.HARYANA.getCity()[1]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).inputStudentRegForm(student);
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[1]/td[last()]")).getText(), student.getName()+" "+student.getLastName(),
                "Error: name or surname failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[2]/td[last()]")).getText(), student.getEmail(),
                "Error: email failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[3]/td[last()]")).getText(), student.getGender(),
                "Error: gender failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[4]/td[last()]")).getText(), student.getMobile(),
                "Error: phone failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[5]/td[last()]")).getText(), student.getDateOfBirth(),
                "Error: birthdate failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[6]/td[last()]")).getText(), student.getSubjects(),
                "Error: subjects failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[7]/td[last()]")).getText(), student.getHobbies(),
                "Error: hobbies failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[8]/td[last()]")).getText(), student.getPicture(),
                "Error: picture failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[9]/td[last()]")).getText(), student.getAddress(),
                "Error: address failed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[10]/td[last()]")).getText(), student.getState()+" "+student.getCity(),
                "Error: state or city failed");
        softAssert.assertAll();
    }
}
