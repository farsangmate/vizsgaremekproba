import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ProfileTest extends TestUtilities {

    @Test
    @Order(1)
    @DisplayName("A profil adatainak módosítása")
    @Description("Felhasználó adatainak módosításának tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testEditProfile() throws InterruptedException {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME,VALIDPASSWORD);
        profilePage.navigateToProfilePage();
        profilePage.modifyProfile("Vagasi Ferenc","beszálltam az internetbe","1233456");
        Thread.sleep(150);
        boolean actual = profilePage.isEditSuccessful();
        Assertions.assertTrue(actual);
    }

    @Test
    @Order(2)
    @DisplayName("A profil adatainak módosítása,beviteli mezők tesztelése")
    @Description("Beviteli mezők tesztelése. Adatok megadása, törlése majd újbóli megadása")
    @Severity(SeverityLevel.NORMAL)
    public void testModify() throws InterruptedException {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME,VALIDPASSWORD);
        profilePage.navigateToProfilePage();
        profilePage.modifyProfile("1233456","beszálltam az internetbe","Vagasi Ferenc");
        Thread.sleep(150);
        profilePage.deleteFields();
        Thread.sleep(150);
        profilePage.modifyProfile("Vagasi Ferenc","beszálltam az internetbe","1233456");
        boolean actual = profilePage.isEditSuccessful();
        Assertions.assertTrue(actual);
    }

    @Test
    @Order(2)
    @DisplayName("Profil törlése")
    @Description("Profil törlésének tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteProfile() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME,VALIDPASSWORD);
        profilePage.deleteProfile();
        String wrongURL = "https://lennertamas.github.io/roxo/profile";
        String actualResult = driver.getCurrentUrl();
        Assertions.assertNotEquals(wrongURL,actualResult);
    }

    @Test
    @Order(2)
    @DisplayName("Profil törlése és belépés")
    @Description("Profil törlése, majd azzal való bejelentkezés tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteProfileAndLogin() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.register("Mate","Farsang","farsangmate","matefarsang");
        basePage.navigate();
        basePage.login("Mate","Farsang");
        profilePage.deleteProfile();
        basePage.navigate();
        basePage.login("Mate","Farsang");
        String actual = basePage.getLoginText();
        String expected = "Username or Password\n" +
                "is not correct!";
        Assertions.assertEquals(expected,actual);

    }

    @Test
    @Order(2)
    @DisplayName("Adatok törlése")
    @Description("Adatok bevitele majd törlése")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteData() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME,VALIDPASSWORD);
        profilePage.navigateToProfilePage();
        profilePage.modifyProfile("Vagasi Ferenc","beszálltam az internetbe","1233456");
        profilePage.deleteFields();
        String[] expectedResult = expectedEmptyArray();
        String[] actualResult = profilePage.inputFieldsList();
        Assertions.assertArrayEquals(expectedResult,actualResult);
    }
}
