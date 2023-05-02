import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class AboutTest extends TestUtilities {


    @Test
    @Order(1)
    @DisplayName("Dolgozók nevének ellenőrzése")
    @Description("Dolgozók nevének kiolvasása és külső fájlból kiolvasott adatokkal való összehasonlítás")
    @Severity(SeverityLevel.NORMAL)
    public void getNamesTest() throws InterruptedException {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME,VALIDPASSWORD);
        aboutPage.getNames();
        String[] actualResult = aboutPage.getNames();
        String[] expectedResult = aboutPage.ReadFromFile();
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @Order(2)
    @DisplayName("Leírás ellenőrzése")
    @Description("A leírás fájlba történő kiírása majd összehasonlítása az elvárt szöveggel")
    public void testSaveTextFromAboutPage(){
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME,VALIDPASSWORD);
        String actual = aboutPage.writeToFile();
        String expected = "[We are specialized in developing forward-thinking brand identities, websites, illustration and animation for all types of customers. And we do this by bringing our customers through each phase of the design process with us.]";
        Assertions.assertEquals(expected,actual);
    }
}

