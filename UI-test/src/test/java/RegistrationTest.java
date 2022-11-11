import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.Generator;
import pageObject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;


public class RegistrationTest {

    @Test
    @DisplayName("Создание нового пользователя с ваидными данными")
    public void userRegisterValidDataTest() {

        open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButton()
                .setName(Generator.getRandomUser().getName())
                .setEmail(Generator.getRandomUser().getEmail())
                .setPassword(Generator.getRandomUser().getPassword())
                .clickConfirmRegistrationButton()
                .waitForAuthButton();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals( "https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

}
