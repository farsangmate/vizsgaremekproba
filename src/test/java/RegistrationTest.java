import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class RegistrationTest extends TestUtilities {

    @Test
    @Order(1)
    @DisplayName("Regisztráció helyes adatokkal")
    @Description("Regisztráció tesztelése megfelelő formátumú adatokkal")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationValidData() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.register(USERNAMEREG, PASSWORDREG, EMAILREG, DESCRIPTIONREG);
        String actualResult = basePage.getRegisterText();
        Assertions.assertEquals(MSG_SUCCESFULLREG, actualResult);
    }
    @Test
    @Order(2)
    @DisplayName("Regisztráció helytelen adatokkal")
    @Description("Regisztráció tesztelése nem megfelelő formátumú adatokkal")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationInvalidData() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.register(USERNAMEREG, PASSWORDREG, EMAILREGWRONG, DESCRIPTIONREG);
        String actualResult = basePage.getRegisterText();
        Assertions.assertNotEquals(MSG_SUCCESFULLREG, actualResult);
    }


    @Test
    @Order(3)
    @DisplayName("Regisztráció üres mezőkkel")
    @Description("Regisztráció tesztelése a mezők kitöltése nélkül")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmptyFields() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.register("", "", "", "");
        String actualResult = basePage.getRegisterText();
        Assertions.assertNotEquals(MSG_SUCCESFULLREG, actualResult);
    }

    @Test
    @Order(4)
    @DisplayName("Regisztráció és ellenőrzés")
    @Description("Egy felhasználó létrehozása majd azzal történő bejelentkezés")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationAndVerify() throws InterruptedException {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.register(USERNAMEREG, PASSWORDREG, EMAILREG, DESCRIPTIONREG);
        basePage.refreshPage();
        basePage.login(USERNAMEREG, PASSWORDREG);
        String actualResult = basePage.getLogoutText();
        Assertions.assertEquals(LOGOUTTEXT, actualResult);
    }
}
