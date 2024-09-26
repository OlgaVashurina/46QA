package lessons.lesson_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize(); // развернуть браузер на весь экран
    }

    @Test
    public void findElementsByTagName() {
      WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1);
        System.out.printf(h1.getText());

        WebElement a = driver.findElement(By.tagName("a"));
        System.out.println(a.getSize());

        List<WebElement> element_a = driver.findElements(By.tagName("a"));
        System.out.printf("Size of List: " + element_a.size());
        System.out.printf("Size of element #5: " + element_a.get(5));

        for(WebElement element: element_a){
            System.out.println(element.getAttribute("href"));
            System.out.println(element.getText());
        }

    }


    @AfterMethod(enabled = true) //если поменять на false то браузер не закроется
    public void tearDown() {
        driver.quit();

    }
}