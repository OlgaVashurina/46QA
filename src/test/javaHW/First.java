import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class First {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        // driver.manage().window().setPosition(new Point(0, 2500)); //- отображение на 2 мониторе
        driver.manage().window().setPosition(new Point(0, 0)); // переместить окно на второй монитор слева
        System.out.println(driver.manage().window().getPosition());

        //  driver.manage().window().maximize(); // развернуть браузер на весь экран
    }

    // Пример 1: Проверка заголовка страницы
    @Test
    public void checkTitle() {
        String expectedTitle = "Demo Web Shop";
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);
        assert actualTitle.equals(expectedTitle) : "Page title is not as expected!";
    }
    // Пример 2: Проверка присутствия элемента (например, логотипа)
    @Test
    public void checkLogoPresence() {
        boolean isLogoPresent = driver.findElement(By.id("nivo-slider")).isDisplayed(); // Логотип сайта
        assert isLogoPresent : "Logo is not displayed!";
    }

    // Пример 3: Проверка кликабельности ссылки "Register"
    @Test
    public void checkRegisterLink() {
        driver.findElement(By.linkText("Register")).click();
        String expectedUrl = "https://demowebshop.tricentis.com/register";
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(expectedUrl) : "Register link is not working as expected!";
    }

    @Test
    public void fillRegistrationForm() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click(); // Выбор пола
        driver.findElement(By.id("FirstName")).sendKeys("Alexander"); // Имя
        driver.findElement(By.id("LastName")).sendKeys("Smith"); // Фамилия
        driver.findElement(By.id("Email")).sendKeys("alsdfgsfgh@example.com"); // Email
        driver.findElement(By.id("Password")).sendKeys("Parw01l@2024"); // Пароль
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Parw01l@2024"); // Подтверждение пароля
        driver.findElement(By.id("register-button")).click(); // Клик на кнопку регистрации

        // Явное ожидание (Explicit Wait) для элемента с классом "result"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));

        boolean isRegistrationSuccessful = driver.findElement(By.className("result")).getText().contains("Your registration completed");
        assert isRegistrationSuccessful : "Registration failed!";
    }

    // Пример 5: Проверка поиска товара
    @Test
    public void searchProduct() {
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.cssSelector("input[value='Search']")).click(); // Кнопка поиска

        boolean isSearchSuccessful = driver.findElements(By.cssSelector(".product-item")).size() > 0;
        assert isSearchSuccessful : "Search results not found!";
    }

    @AfterMethod(enabled = true) //если поменять на false то браузер не закроется
    public void tearDown() {
        driver.quit();
    }
}