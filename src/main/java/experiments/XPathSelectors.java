package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsRadiobuttonTextbox() {
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();

        hideBanner();
        hideFooter();

        WebElement radioButtonYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioButtonYes.click();
        WebElement radioButtonImpressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        radioButtonImpressive.click();
        WebElement radioButtonNo = driver.findElement(By.xpath("//label[@for='noRadio']"));
        radioButtonNo.click();
        pause(2);
        WebElement pageTextbox = driver.findElement(By.xpath("//span[text()='Text Box']"));
        pageTextbox.click();
        WebElement inputName = driver.findElement(By.xpath("//input[@id='userName']"));
        inputName.sendKeys("Pippin Took");
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        inputEmail.sendKeys("secondbreakfast@gmail.com");
        WebElement textareaCurrentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        textareaCurrentAddress.sendKeys("On the road with Gandalf, trying not to touch things");
        WebElement textareaPermanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        textareaPermanentAddress.sendKeys("Tookland, the Shire");
        WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
        btnSubmit.click();

        WebElement output = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(output.getText());

        pause(4);
        driver.quit();
    }

    public void pause (int time) {
        try {
            Thread.sleep(time*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
