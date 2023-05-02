import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class ButtonsTest extends TestUtilities {

    @BeforeEach
    public void beforeTestButtons() {
        basePage.navigate();
        basePage.acceptTAC();
        basePage.login(VALIDUSERNAME, VALIDPASSWORD);
    }

    @Test
    @Order(8)
    @DisplayName("Home button test")
    @Description("Testing if the 'Home' button opens the right page")
    @Severity(SeverityLevel.NORMAL)
    public void testHomeButton() {
        String expectedHomePage = "https://lennertamas.github.io/roxo/landing.html";
        String homePage = basePage.homeButtonURL();
        Assertions.assertEquals(expectedHomePage, homePage);
    }

    @Test
    @Order(1)
    @DisplayName("About button test")
    @Description("Testing if the 'About' button opens the right page")
    @Severity(SeverityLevel.NORMAL)
    public void testAboutButton() {
        String expectedAboutPage = "https://lennertamas.github.io/roxo/about/";
        String aboutPage = basePage.aboutButtonURL();
        Assertions.assertEquals(expectedAboutPage, aboutPage);
    }

    @Test
    @Order(2)
    @DisplayName("Portfolio button test")
    @Description("Testing if the 'Porfolio' button opens the right page")
    @Severity(SeverityLevel.NORMAL)
    public void testPortfolioButton() {
        String expectedPortfolioPage = "https://lennertamas.github.io/roxo/portfolio/";
        String portfolioPage = basePage.portfolioButtonURL();
        Assertions.assertEquals(expectedPortfolioPage, portfolioPage);
    }

    @Test
    @Order(3)
    @DisplayName("Blog button test")
    @Description("Testing if the 'Blog' button opens the right page")
    @Severity(SeverityLevel.NORMAL)
    public void testBlogButton() {
        String expectedBlogPage = "https://lennertamas.github.io/roxo/blog/";
        String blogPage = basePage.blogButtonURL();
        Assertions.assertEquals(expectedBlogPage, blogPage);
    }

    @Test
    @Order(4)
    @DisplayName("Get in touch button test")
    @Description("Testing if the 'Get in touch' button opens the right page")
    @Severity(SeverityLevel.NORMAL)
    public void testContactButton() {
        String expectedContactPage = "https://lennertamas.github.io/roxo/contact/";
        String contactPage = basePage.contactButtonURL();
        Assertions.assertEquals(expectedContactPage, contactPage);
        basePage.goToMainPage();
    }

    @Test
    @Order(5)
    @DisplayName("Profile button test")
    @Description("Testing if the 'Profile' button opens the right page")
    @Severity(SeverityLevel.NORMAL)
    public void testProfileButton() {
        String expectedProfilePage = "https://lennertamas.github.io/roxo/profile";
        String profilePage = basePage.profileButtonURL();
        Assertions.assertEquals(expectedProfilePage, profilePage);
    }

    @Test
    @Order(6)
    @DisplayName("Connect With Us button test")
    @Description("Testing if the 'Connect With Us' button opens the right page")
    @Severity(SeverityLevel.NORMAL)
    public void testConnectWithUs() {
        String expectedContactPage = "https://lennertamas.github.io/roxo/contact/";
        String contactPage = basePage.connectWithUsButtonURL();
        Assertions.assertEquals(expectedContactPage, contactPage);
        basePage.goToMainPage();
    }

    @Test
    @Order(7)
    @DisplayName("See Our Work button test")
    @Description("Testing if the 'See Our Work' button opens the right page")
    @Severity(SeverityLevel.NORMAL)
    public void testSeeOurWorkButton() {
        String expectedPortfolioPage = "https://lennertamas.github.io/roxo/portfolio/";
        String portfolioPage = basePage.seeOurWorksButtonURL();
        Assertions.assertEquals(expectedPortfolioPage, portfolioPage);
    }

}
