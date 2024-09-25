import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumProject {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //driver.manage().window().setPosition(new Point(2500, 0)); - отображение на 2 мониторе
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