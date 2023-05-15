package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class LoginSecondTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
        new AuthenticationScreen(driver)
                .fillEmail("shilol@gmail.com")
                .fillPassword("Shilol12345$")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void loginSuccessModel(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("shilol@gmail.com").password("Shilol12345$").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }
    @Test
    public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("shilolgmail.com").password("Shilol12345$").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }

    @Test
    public void loginWrongPassword(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("shilol@gmail.com").password("Shilol123").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }
    @AfterMethod
    public void posCondition(){
        new ContactListScreen(driver).logout();
    }

}
