import com.thoughtworks.qdox.parser.ParseException;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class LoginAndLogoutTest extends TestUtilities {


    private static final Map<String, String> loginData = new HashMap<>();


    @BeforeAll
    static void beforeAll() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("RegistrationDetails.json"));
        JSONArray solutions = (JSONArray) obj;
        for (Object solution : solutions) {
            String username = ((JSONObject) solution).get("Username").toString();
            String password = ((JSONObject) solution).get("Password").toString();
            loginData.put(username, password);
        }
    }

    @Test
    @Order(1)
    @DisplayName("Bejelentkezés érvényes adatokkal")
    @Description("Bejelentkezés tesztelése helyes felhasználói adatokkal")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithValidUser() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
        String actualResult = basePage.getLogoutText();
        String expectedResult = "Logout";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Order(2)
    @DisplayName("Bejelentkezés üres mezőkkel")
    @Description("Bejelentkezés tesztelése a mezők kitöltése nélkül")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithEmptyInput() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login("", "");
        String actualResult = basePage.getLoginText();
        Assertions.assertEquals(LOGINFAILMSG, actualResult);
    }

    @Test
    @Order(3)
    @DisplayName("Bejelentkezés helytelen adatokkal")
    @Description("Bejelentkezés tesztelése helytelen felhasználói adatokkal")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithInvalidUser() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(WRONGUSERNAME, WRONGPASSWORD);
        String actualResult = basePage.getLoginText();
        Assertions.assertEquals(LOGINFAILMSG, actualResult);


    }

    @Test
    @Order(4)
    @DisplayName("Bejelentkezés több felhasználóval")
    @Description("Bejelentkezés tesztelése több felhasználóval, adatok beolvasása külső fájlból")
    @Severity(SeverityLevel.CRITICAL)

    public void testLoginMultipleUsers() throws InterruptedException {
        basePage.navigate();
        basePage.acceptTAC();
        for (String key : loginData.keySet()) {
            basePage.login(key, loginData.get(key));
            String actualResult = basePage.getLogoutText();
            String expectedResult = "Logout";
            Thread.sleep(500);
            Assertions.assertEquals(expectedResult, actualResult);
            basePage.navigate();
        }
    }


    @Test
    @Order(5)
    @DisplayName("Kijelentkezés")
    @Description("Kijelentkezés funkció tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testLogout() {
        BasePage basePage = new BasePage(driver);
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
        basePage.logout();
        String actualResult = driver.getCurrentUrl();
        Assertions.assertEquals(LOGINPAGEURL, actualResult);
    }
}
