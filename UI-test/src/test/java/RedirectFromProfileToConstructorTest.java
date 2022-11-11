import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RedirectFromProfileToConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход из Личного кабинете на главную через кнопку Конструтора")
    public void redirectConstructorButtonTest() throws InterruptedException {
        var redirectPage = page(LoginPage.class);
        Thread.sleep(250);

        redirectPage.loginUser(user)
                .clickProfileButtonAfterAuth()
                .clickConstructorButton()
                .isBurgerConstructorHeaderExist();
    }

    @Test
    @DisplayName("Переход из Личного кабинете на главную через кнопку Лого")
    public void redirectLogoButtonTest() throws InterruptedException {
        var redirectPage = page(LoginPage.class);
            Thread.sleep(250);

                redirectPage.loginUser(user)
                .clickProfileButtonAfterAuth()
                .clickLogoButton()
                .isBurgerConstructorHeaderExist();
    }
}
