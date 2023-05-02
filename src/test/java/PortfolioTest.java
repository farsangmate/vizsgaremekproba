import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class PortfolioTest extends TestUtilities {

    @Test
    @Order(1)
    @DisplayName("Termék nevek ellenőrzése")
    @Description("Termékek kiolvasása az összes oldalról és azok ellenőrzése")
    @Severity(SeverityLevel.NORMAL)
    public void testGetProducts() throws InterruptedException {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME,VALIDPASSWORD);
        portfolioPage.navigateToPortfolioPage();
        String[] actualResult = portfolioPage.getItemNames();
        String[] expectedResult = {"KIO-TAPE BRAND", "USE-LESS BRAND", "OSEN CLOCK", "SEAMLESS WATCH", "KIO TAPE"};
        Assertions.assertArrayEquals(expectedResult,actualResult);
    }

}
