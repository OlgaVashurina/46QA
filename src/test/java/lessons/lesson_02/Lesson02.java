package lessons.lesson_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lesson02 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
        driver.manage().window().maximize(); // развернуть браузер на весь экран
    }

    @Test
    public void firstTest() {
        System.out.println("Google hi!!"); //не можем оставить пустой!!!! нужна анотация тест
    }

    @AfterMethod(enabled = true) //если поменять на false то браузер не закроется
    public void tearDown() {
        driver.quit();

    }
}
