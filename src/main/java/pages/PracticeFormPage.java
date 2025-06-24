package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

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

    @FindBy(css = "div#state")
    WebElement divState;
    @FindBy(css = "#react-select-3-input")
    WebElement inputState;
    @FindBy(css = "div#city")
    WebElement divCity;
    @FindBy(xpath = "//input[@id='react-select-4-input']")
    WebElement inputCity;

    @FindBy(css = "textarea#currentAddress")
    WebElement textareaAddress;

    @FindBy(css = "button#submit")
    WebElement btnSubmit;

    @FindBy(css = "#example-modal-sizes-title-lg")
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
        typeSubjects(student.getSubjects());
        clickHobbies(student.getHobbies());
        textareaAddress.sendKeys(student.getAddress());
//        doesn't click the input because of viewport
        enterStateCity(student.getState(), student.getCity());

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

    private void typeSubjects(String subjects) {
        inputSubjects.click();
        String [] arr = subjects.split(",");
        for (String s : arr) {
            inputSubjects.sendKeys(s);
            inputSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void clickHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            driver.findElement(By.xpath(h.getLocator())).click();
//            switch (h) {
//                case SPORTS: driver.findElement(By.xpath(h.getLocator())).click();
//                case READING: driver.findElement(By.xpath(h.getLocator())).click();
//                case MUSIC: driver.findElement(By.xpath(h.getLocator())).click();
//            }
        }
    }

    private void enterStateCity(String state, String city) {
        int width = inputState.getRect().getWidth();
        int height = inputState.getRect().getHeight();
        System.out.println("checkbox: " + width + " X " + height);
        divState.click();
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);
        divCity.click();
        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
    }

    public boolean validateModalMessage() {
        return isTextInElement(tableResults, "Thanks for submitting the form");
    }
}
