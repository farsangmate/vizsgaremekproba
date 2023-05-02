import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private final By BUTTON_CONTACT = By.xpath("//*[@data-text=\"Get in touch\"]");

    private final By INPUT_FIRSTNAME =By.id("first-name");
    private final By INPUT_LASTNAME = By.id("last-name");
    private final By INPUT_EMAIL = By.id("email");
    private final By INPUT_PROJECTTYPE = By.id("projectType");
    private final By INPUT_ABOUTPROYECT = By.id("aboutProject");
    private final By BUTTON_SENDMSG = By.xpath("//*[@onclick=\"myFunction()\"]");


    public void fillContact(String firstName,String lastName,String email,String projectType,String aboutProject) {
        driver.findElement(BUTTON_CONTACT).click();
        driver.findElement(INPUT_FIRSTNAME).sendKeys(firstName);
        driver.findElement(INPUT_LASTNAME).sendKeys(lastName);
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        Select drpProjectType = new Select(driver.findElement(INPUT_PROJECTTYPE));
        drpProjectType.selectByVisibleText(projectType);
        driver.findElement(INPUT_ABOUTPROYECT).sendKeys(aboutProject);
        Actions action = new Actions(driver);
        WebElement element =driver.findElement(BUTTON_SENDMSG);
        action.doubleClick(element).perform();
    }
    public String handleAlertAndGetMsg() {
        String msg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return msg;

    }

}
