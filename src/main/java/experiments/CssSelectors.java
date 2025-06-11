package experiments;

import org.openqa.selenium.By;
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

        WebElement footer = driver.findElement(By.tagName("footer"));

        WebElement btnLogo = driver.findElement(By.cssSelector("img[src=\"/images/Toolsqa.jpg\"]"));
        System.out.println(btnLogo.getTagName());
        System.out.println(btnLogo.getAttribute("src"));

//        WebElement btnCard = driver.findElement(By.cssSelector(".card-up"));
//        btnCard.click();

        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();

        WebElement btnRadioButton = driver.findElement(By.id("item-2"));
        btnRadioButton.click();

        pause(10);
        driver.quit();
    }

    public void pause (int time) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
