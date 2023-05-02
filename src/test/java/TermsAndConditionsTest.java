import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TermsAndConditionsTest extends TestUtilities {
    public WebDriver driver;


    @Test
    @Order(1)
    @DisplayName("'Terms and conditions' megjelenése")
    @Description("A 'Terms and conditions' ablak láthatóságának tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testTermsAndConditions() {
        basePage.navigate();
        Assertions.assertTrue(basePage.isTACVisible());
    }

    @Test
    @Order(2)
    @DisplayName("'Terms and conditions' elfogadása")
    @Description("A 'Terms and conditions' ablak felugrik és a felhasználó el tudja fogadni")
    @Severity(SeverityLevel.NORMAL)
    public void testTermsAndConditionsAfterClick() {
        basePage.navigate();
        basePage.acceptTAC();
        Assertions.assertFalse(basePage.isTACVisible());
    }

    @Test
    @Order(3)
    @DisplayName("'Terms and conditions' elfogadása majd frissítés")
    @Description("'Terms and conditions' elfogadása, majd ellenőrzés, hogy ismét megjelenik-e")
    @Severity(SeverityLevel.NORMAL)
    public void testTermsAndConditionsAcceptAndRefresh() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.refreshPage();
        Assertions.assertFalse(basePage.isTACVisible());
    }

    @Test
    @Order(4)
    @DisplayName("'Terms and conditions' elutasítása majd frissítés")
    @Description("'Terms and conditions' ablak bezárása,majd ellenőrzés, hogy ismét megjelenik-e")
    @Severity(SeverityLevel.NORMAL)
    public void testTermsAndConditionsXAndRefresh() {
        basePage.navigate();
        basePage.closeTAC();
        basePage.refreshPage();
        Assertions.assertTrue(basePage.isTACVisible());
    }
}
