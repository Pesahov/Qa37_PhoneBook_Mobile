package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    // xpath="//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView"
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityTextView;
    @FindBy(xpath = "//*[@content-desc='More options']")
    AndroidElement menuOptions;
    @FindBy(xpath = "//*[@text='Logout']")
    AndroidElement logoutButton;


    public ContactListScreen isAccountOpened(){
        Assert.assertTrue(isActivityTitleDisplayed("Contact list"));
        return this;
    }
    public boolean isActivityTitleDisplayed(String text){
        //return activityTextView.getText().contains("Contact list");
        return isShouldHave(activityTextView,text,10);
    }

    public AuthenticationScreen logout(){
        menuOptions.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }
}