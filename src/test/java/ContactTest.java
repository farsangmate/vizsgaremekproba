import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ContactTest extends TestUtilities {

    @Test
    @Order(1)
    @DisplayName("Üzenetküldés tesztelése")
    @Description("Üzenetküldés funkció tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void testFillContact() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillContact("Teszt","Elek","tesztelek@gmail.com","Web Design","Everything is beautiful");
        Thread.sleep(300);
        String actualResult = contactPage.handleAlertAndGetMsg();
        String expectedResult = "Message sent!";
        makeScreenshot("Message sent succesful");
        Assertions.assertEquals(expectedResult,actualResult);
    }
}
