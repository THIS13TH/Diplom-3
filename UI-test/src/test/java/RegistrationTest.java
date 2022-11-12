import api.Generator;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegistrationTest{

    @Test
    @DisplayName("Создание нового пользователя с ваидными данными")
    public void userRegisterValidDataTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButtonLoginPage()
                .setName(Generator.getRandomUser().getName())
                .setEmail(Generator.getRandomUser().getEmail())
                .setPassword(Generator.getRandomUser().getPassword())
                .clickConfirmRegistrationButton()
                .waitForAuthButton();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals( "https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

    @Test
    @DisplayName("Создание пользователя с некорректным паролем")
    public void userRegisterNoValidDataTest() {
        String password = "1234";
        open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButtonLoginPage()
                .setName(Generator.getRandomUser().getName())
                .setEmail(Generator.getRandomUser().getEmail())
                .setPassword(password)
                .clickConfirmRegistrationButton()
                .isErrorMessageAppear();
    }

}
