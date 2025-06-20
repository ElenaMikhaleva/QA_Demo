package pages;

import dto.Student;
import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    WebElement textareaAddress;

    @FindBy(css = "button#submit")
    WebElement btnSubmit;

    @FindBy(xpath = "//table[contains(@class, 'table table-dark table-striped table-bordered table-hover')]")
    WebElement tableResults;

    public void inputStudentRegForm(Student student) {
        hideBanner();
        hideFooter();

        inputFirstName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        clickGender(student.getGender());
        inputPhone.sendKeys(student.getMobile());
        enterDateOfBirth(student.getDateOfBirth());
//        inputSubjects.sendKeys(subjects);

//        if (hobbySports) checkboxHobbiesSports.click();
//        if (hobbyReading) checkboxHobbiesReading.click();
//        if (hobbyMusic) checkboxHobbiesMusic.click();

        textareaAddress.sendKeys(student.getAddress());
        // state
        // city

        btnSubmit.click();
        System.out.println(tableResults.getText());
    }

    private void clickGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

    private void enterDateOfBirth(String birthDate) {
        inputBirthDate.click(); // сделали его активным
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win")) {
            inputBirthDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        inputBirthDate.sendKeys(birthDate);
        inputBirthDate.sendKeys(Keys.ENTER);
    }
}
