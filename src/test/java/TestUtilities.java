import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestUtilities {
    WebDriver driver;
    BasePage basePage;
    AboutPage aboutPage;
    BlogPage blogPage;
    ContactPage contactPage;
    PortfolioPage portfolioPage;
    ProfilePage profilePage;

    public final String VALIDUSERNAME = "lovasia";
    public final String VALIDPASSWORD = "kispal123";
    public final String USERNAMEREG = "TakiBacsi";
    public final String PASSWORDREG = "TakiBa123";
    public final String EMAILREG = "takacsistvan@gmail.com";
    public final String EMAILREGWRONG = "takacsistvangmail.com";
    public final String DESCRIPTIONREG = "magántaxis";
    public final String MSG_SUCCESFULLREG = "User registered!";
    public final String LOGOUTTEXT = "Logout";
    public final String WRONGUSERNAME = "VagasiFeri";
    public final String WRONGPASSWORD = "halenne10kforintom";
    public final String LOGINPAGEURL = "https://lennertamas.github.io/roxo/index.html";
    public final String LOGINFAILMSG = "Username or Password\n" +
            "is not correct!";


    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));

        basePage = new BasePage(driver);
        aboutPage = new AboutPage(driver);
        blogPage = new BlogPage(driver);
        contactPage = new ContactPage(driver);
        portfolioPage = new PortfolioPage(driver);
        profilePage = new ProfilePage(driver);
    }

    public String[] expectedEmptyArray() {
        List<String> expectedArray = new ArrayList();
        for (int i = 0; i < 3; i++) {
            expectedArray.add("");
        }
        String[] stringArray = expectedArray.toArray(new String[0]);
        return stringArray;
    }


    public void makeScreenshot(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
