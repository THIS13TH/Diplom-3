import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class LogoutButtonTest extends BaseTest{


    @Test
    @DisplayName("Выйти из личного кабинета через кнопку Выйти")
    public void logoutProfileButton() throws InterruptedException {
        final var logOut = page(LoginPage.class);

        Thread.sleep(250);

        logOut.setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .clickProfileButtonAfterAuth()
                .clickExitButton()
                .isEnterButtonExist();


    }
}