package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class MainPage {
    public static String URL_MAIN = "https://stellarburgers.nomoreparties.site/";

    //Кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Оформить заказ')]")
    private SelenideElement createOrderButton;

    //Кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement personalProfileButton;

    //Заголовок Соберите бургер
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    private SelenideElement burgerConstructionHeader;

    // Раздел Булки
    @FindBy(how = How.XPATH, using = "//div[span[text()='Булки']]")
    private SelenideElement buttonBuns;

    // Раздел Соусы
    @FindBy(how = How.XPATH, using = "//div[span[text()='Соусы']]")
    private SelenideElement buttonSauce;

    //Раздел Начинки
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement buttonFillings;

    //наименования класса  после выбора раздела
    @FindBy(how = How.CLASS_NAME, using = "tab_tab_type_current__2BEPc")
    private SelenideElement sectionIngredients;

    @FindBy(how = How.XPATH, using = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']")
    private SelenideElement constructorContainer;


    @Step("Кликнуть Войти в аккаунт")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Зарегистрировать нового пользователя")
    public void createUser(User user) {

        open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButton()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickButtonRegistration();
    }

    @Step("Проверить кнопку Оформить заказ")
    public boolean isCreateOrderButtonAppear() {
        createOrderButton.shouldBe(Condition.visible);
        return createOrderButton.exists();
    }

    @Step("Кликнуть на кнопку Личного кабинета до авторизации")
    public LoginPage clickProfileButtonBeforeAuth() {
        personalProfileButton.click();
        return page(LoginPage.class);
    }

    @Step("Кликнуть на кнопку Личного кабинета после авторизации")
    public ProfilePage clickProfileButtonAfterAuth() {
        personalProfileButton.click();
        return page(ProfilePage.class);
    }

    @Step("Создать рандомного пользователя и войти")
    public MainPage createUserAndLogin(User user) {

        return open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButton()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickConfirmRegistrationButton()
                .enterHeaderShouldBeVisible()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton();
    }

    @Step("Проверить заголовок Конструктор")
    public boolean isBurgerConstructorHeaderExist() {
        return burgerConstructionHeader.exists();
    }

    @Step("Кликнуть на Булочки в Конструторе")
    public MainPage clickBunsButton() {
        buttonBuns.click();
        return this;
    }

    @Step("Кликнуть на соусы в конструкторе")
    public MainPage clickSaucesButton() {
        buttonSauce.click();
        return this;
    }

    @Step("Кликнуть на Начинки в конструкторе")
    public MainPage clickFillingsButton() {
        buttonFillings.click();
        return this;
    }

    @Step("Проверить что заголовок Булки появился")
    public boolean isBunsHeaderIsDisplayed() {
        return buttonBuns.isDisplayed();
    }

    @Step("Проверить что заголовок Соусы появился")
    public boolean isSaucesHeaderDisplayed() {
        return buttonSauce.isDisplayed();
    }

    @Step("Проверить что заголовок Начинки появился")
    public boolean isFillingsHeaderDisplayed() {
        return buttonFillings.isDisplayed();
    }

    @Step("Скролл до Булочек")
    public MainPage scrollToBunsHeader() {
        constructorContainer.click();
        buttonBuns.scrollTo();
        return this;
    }

    @Step("Скролл до Соусов")
    public MainPage scrollToSaucesHeader() {
        constructorContainer.click();
        buttonSauce.scrollTo();
        return this;
    }

    @Step("Скролл до Начинок")
    public MainPage scrollToIngredientsHeader() {
        constructorContainer.click();
        buttonFillings.scrollTo();
        return this;
    }

    @Step("Ожидание загрузки конструтора")
    public MainPage constructionShouldBeVisible() {
        constructorContainer.shouldBe(Condition.visible);
        return this;
    }
}
