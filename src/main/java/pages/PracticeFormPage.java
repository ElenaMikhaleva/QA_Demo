package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(css = "input#firstName")
    WebElement inputFirstName;

    @FindBy(css = "input#lastName")
    WebElement inputLastName;

    @FindBy(css = "input#userEmail")
    WebElement inputEmail;

    @FindBy(css = "label[for='gender-radio-1']")
    WebElement btnGenderMale;
    @FindBy(css = "label[for='gender-radio-2']")
    WebElement btnGenderFemale;
    @FindBy(css = "label[for='gender-radio-3']")
    WebElement btnGenderOther;

    @FindBy(css = "input#userNumber")
    WebElement inputPhone;

    @FindBy(css = "input#dateOfBirthInput")
    WebElement inputBirthDate;

    @FindBy(css = "input#subjectsInput")
    WebElement inputSubjects;

    @FindBy(css = "label[for='hobbies-checkbox-1']")
    WebElement checkboxHobbiesSports;
    @FindBy(css = "label[for='hobbies-checkbox-2']")
    WebElement checkboxHobbiesReading;
    @FindBy(css = "label[for='hobbies-checkbox-3']")
    WebElement checkboxHobbiesMusic;

    @FindBy(css = "textarea#currentAddress")
    WebElement inputAddress;

    @FindBy(css = "button#submit")
    WebElement btnSubmit;

    @FindBy(xpath = "//table[contains(@class, 'table table-dark table-striped table-bordered table-hover')]")
    WebElement tableResults;

    public void inputStudentRegForm(String firstName, String lastName, String email, String gender, String phone,
                                    String birthdate, String subjects, boolean hobbySports, boolean hobbyReading, boolean hobbyMusic,
                                    String address) {
        hideBanner();
        hideFooter();
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);

        switch (gender) {
            case "Male":
                btnGenderMale.click();
                break;
            case "Female":
                btnGenderFemale.click();
                break;
            case "Other":
                btnGenderOther.click();
                break;
        }

        inputPhone.sendKeys(phone);
//        inputBirthDate.sendKeys(birthdate);
//        inputSubjects.sendKeys(subjects);

        if (hobbySports) checkboxHobbiesSports.click();
        if (hobbyReading) checkboxHobbiesReading.click();
        if (hobbyMusic) checkboxHobbiesMusic.click();

        inputAddress.sendKeys(address);
        // state
        // city

        btnSubmit.click();
        System.out.println(tableResults.getText());
    }
}
