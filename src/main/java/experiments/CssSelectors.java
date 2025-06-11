package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        hideBanner();
        hideFooter();

        WebElement footer = driver.findElement(By.tagName("footer"));

        WebElement btnLogo = driver.findElement(By.cssSelector("img[src=\"/images/Toolsqa.jpg\"]"));
        System.out.println(btnLogo.getTagName());
        System.out.println(btnLogo.getAttribute("src"));

        WebElement divCardElements = driver.findElement(By.cssSelector(".card-up"));
        divCardElements.click();

        pause(5);
        WebElement btnRadioButton = driver.findElement(By.id("item-2"));
        btnRadioButton.click();

        hideFooter();

        WebElement btnRadioButtonYes = driver.findElement(By.cssSelector("label[for=\"yesRadio\"]"));
        btnRadioButtonYes.click();

        pause(5);
        driver.navigate().back();
        driver.navigate().back();

        pause(5);
        WebElement divCardBookStore = driver.findElement(By.cssSelector("[class=\"card mt-4 top-card\"]:last-child"));
        divCardBookStore.click();

        pause(5);
        driver.navigate().back();
        WebElement divCardWidgets = driver.findElement(By.cssSelector("[class='card mt-4 top-card']:nth-child(4)"));
        divCardWidgets.click();

        pause(5);
        driver.quit();
    }

    public void pause (int time) {
        try {
            Thread.sleep(1000);
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
