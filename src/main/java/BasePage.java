import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private final String URL = "https://lennertamas.github.io/roxo/";
    private final String MAINPAGE = "https://lennertamas.github.io/roxo/landing.html";
    private final By BUTTON_TECACCEPT = By.id("terms-and-conditions-button");
    private final By BUTTON_TECCLOSE = By.xpath("//div[@onclick=\"closeModal()\"]");
    private final By WINDOWTAC = By.xpath("//*[@class=\"popup\"]");
    private final By BUTTON_REGISTER = By.id("register-form-button");
    private final By INPUT_REG_USERNAME = By.id("register-username");
    private final By INPUT_REG_PASSWORD = By.id("register-password");
    private final By INPUT_REG_EMAIL = By.id("register-email");
    private final By INPUT_REG_DESCRIPTION = By.id("register-description");
    private final By BUTTON_REGISTERCONFIRM = By.xpath("//*[@onclick=\"registerUser()\"]");
    private final By TEXT_REGISTERCONFIRM = By.id("register-alert");
    private final String USERNAME = "lovasia";
    private final String PASSWORD = "kispal123";

    private final By BUTTON_LOGIN = By.id("login-form-button");
    private final By INPUT_LOGIN_USERNAME = By.id("email");
    private final By INPUT_LOGIN_PASSWORD = By.id("password");

    private final By TEXT_INVALIDLOGIN = By.id("alert");
    private final By BUTTON_LOGINCONFIRM = By.xpath("//*[@onclick=\"myFunction()\"]");
    private final By BUTTON_LOGOUT = By.xpath("//*[@onclick=\"logout()\"]");

    private final By BUTTON_HOME = By.xpath("//*[@class=\"nav-link\"][contains(text(),\"Home\")]");
    private final By BUTTON_ABOUT = By.xpath("//*[@class=\"nav-link\"][contains(text(),\"About\")]");
    public final By BUTTON_PORTFOLIO = By.xpath("//*[@class=\"nav-link\"][contains(text(),\"Portfolio\")]");
    private final By BUTTON_BLOG = By.xpath("//*[@class=\"nav-link\"][contains(text(),\"Blog\")]");
    private final By BUTTON_CONTACT = By.xpath("//span[@data-text=\"Get in touch\"]");
    private final By BUTTON_PROFILE = By.id("profile-btn");
    private final By BUTTON_SEE_OUR_WORKS = By.xpath("//span[@data-text=\"See Our Works\"]");
    private final By BUTTON_CONNECT_WITH_US = By.xpath("//span[@data-text=\"Connect with Us\"]");



    public void navigate() {
        driver.navigate().to(URL);
    }

    public void acceptTAC() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_TECACCEPT)).click();
    }
    public void closeTAC() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_TECCLOSE)).click();
    }
    public boolean isTACVisible() {
        return driver.findElement(WINDOWTAC).isDisplayed();
    }

    public void register(String username, String password, String email, String description) {
        driver.findElement(BUTTON_REGISTER).click();
        fillRegister(username, password, email, description);
        driver.findElement(BUTTON_REGISTERCONFIRM).click();
    }

    public void fillRegister(String username, String password, String email, String description) {
        driver.findElement(INPUT_REG_USERNAME).sendKeys(username);
        driver.findElement(INPUT_REG_PASSWORD).sendKeys(password);
        driver.findElement(INPUT_REG_EMAIL).sendKeys(email);
        driver.findElement(INPUT_REG_DESCRIPTION).sendKeys(description);
    }

    public String getRegisterText() {
        return driver.findElement(TEXT_REGISTERCONFIRM).getText();
    }

    public void login(String username, String password) {
        driver.findElement(BUTTON_LOGIN).click();
        driver.findElement(INPUT_LOGIN_USERNAME).sendKeys(username);
        driver.findElement(INPUT_LOGIN_PASSWORD).sendKeys(password);
        driver.findElement(BUTTON_LOGINCONFIRM).click();

    }

    public String getLoginText() {
        return driver.findElement(TEXT_INVALIDLOGIN).getText();
    }

    public String getLogoutText() {
        return driver.findElement(BUTTON_LOGOUT).getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String homeButtonURL() {
        driver.findElement(BUTTON_HOME).click();
        return driver.getCurrentUrl();
    }
    public String aboutButtonURL() {
        driver.findElement(BUTTON_ABOUT).click();
        return driver.getCurrentUrl();
    }
    public String portfolioButtonURL() {
        driver.findElement(BUTTON_PORTFOLIO).click();
        return driver.getCurrentUrl();
    }
    public String blogButtonURL() {
        driver.findElement(BUTTON_BLOG).click();
        return driver.getCurrentUrl();
    }
    public String contactButtonURL() {
        driver.findElement(BUTTON_CONTACT).click();
        return driver.getCurrentUrl();
    }
    public String profileButtonURL() {
        driver.findElement(BUTTON_PROFILE).click();
        return driver.getCurrentUrl();
    }
    public String seeOurWorksButtonURL() {
        driver.findElement(BUTTON_SEE_OUR_WORKS).click();
        return driver.getCurrentUrl();
    }
    public String connectWithUsButtonURL() {
        driver.findElement(BUTTON_CONNECT_WITH_US).click();
        return driver.getCurrentUrl();
    }
    public void goToMainPage() {
        driver.navigate().to(MAINPAGE);
    }


    public void logout() {
        driver.findElement(BUTTON_LOGOUT).click();
    }
}
