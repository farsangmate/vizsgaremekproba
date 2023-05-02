import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private final By BUTTON_PROFILE = By.id("profile-btn");
    private final By INPUT_NAME = By.xpath("//input[@id=\"name\"]");
    private final By INPUT_BIO = By.xpath("//input[@id=\"bio\"]");
    private final By INPUT_PHONENUMBER = By.xpath("//input[@id=\"phone-number\"]");
    private final By BUTTON_EDITPROFILE = By.xpath("//button[@onclick=\"editUser()\"]");
    private static final By TEXT_VERIFYSUCCESSFUL = By.id("edit-alert");

    private final By BUTTON_DELETEACC = By.xpath("//button[@onclick=\"showRealDeleteAccBtn()\"]");
    private final By BUTTON_CONFIRMDELETE = By.xpath("//button[@onclick=\"deleteAccount()\"]");


    public void navigateToProfilePage() {
        driver.findElement(BUTTON_PROFILE).click();
    }
    public void modifyProfile(String name, String bio, String phoneNumber) {
        driver.findElement(INPUT_NAME).sendKeys(name);
        driver.findElement(INPUT_BIO).sendKeys(bio);
        driver.findElement(INPUT_PHONENUMBER).sendKeys(phoneNumber);
        driver.findElement(BUTTON_EDITPROFILE).click();
        //driver.navigate().back();

    }
    public void deleteFields() {
        driver.findElement(INPUT_NAME).clear();
        driver.findElement(INPUT_BIO).clear();
        driver.findElement(INPUT_PHONENUMBER).clear();
    }

 /*   public ArrayList<String> getTextFromProfile() {
        ArrayList<String> inputTexts = new ArrayList<>();
        //driver.navigate().back();
        //driver.findElement(BUTTON_PROFILE).click();
        inputTexts.add(driver.findElement(INPUT_NAME).getText());
        inputTexts.add(driver.findElement(INPUT_BIO).getText());
        inputTexts.add(driver.findElement(INPUT_PHONENUMBER).getText());

        return inputTexts;
        }*/

    public boolean isEditSuccessful() {
        return driver.findElement(TEXT_VERIFYSUCCESSFUL).isDisplayed();
    }

    public String[] inputFieldsList() {
        List<String> text = new ArrayList<>();
        String name = driver.findElement(INPUT_NAME).getText();
        String bio = driver.findElement(INPUT_BIO).getText();
        String phonenumber = driver.findElement(INPUT_PHONENUMBER).getText();
            text.add(name);
            text.add(bio);
            text.add(phonenumber);
        String[] textArray = text.toArray(new String[0]);
        return textArray;
    }

    public void deleteProfile() {
        driver.findElement(BUTTON_PROFILE).click();
        driver.findElement(BUTTON_DELETEACC).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CONFIRMDELETE)).click();
    }

}
