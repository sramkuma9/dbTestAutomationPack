package bni.regression.pageFactory;

import bni.regression.libraries.common.ReadWritePropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class EditProfile {
    public static WebDriver driver;
    public WebDriverWait wait;
    private ReadWritePropertyFile readWritePropertyFile = new ReadWritePropertyFile();

    @FindBy(css =  "#editMemberMainProfile > label:nth-child(12) > span.fieldtext.fullwidth")
    WebElement companynameTextBox;

    @FindBy(css =  "#editMemberMainProfile > label:nth-child(12) > a")
    WebElement editCompanyButton;

    @FindBy(css =  "#mainProfileUpdate")
    WebElement updateButton;

    @FindBy(css =  "#userprofileicon")
    WebElement userProfileButton;

    @FindBy(css =  "#mainprofileicon")
    WebElement mainProfileButton;

    @FindBy(css =  "#memberLanguage")
    WebElement languageListBox;

    @FindBy(css =  "#editMemberUserProfileSubmitbutton")
    WebElement languageUpdateButton;

    public EditProfile(WebDriver driver) {
        EditProfile.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        //This initElements method will create all WebElements
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void checkCompanyName(String expectedCompanyName){
        String actualCompanyName = companynameTextBox.getText();
        assertEquals("companyName is not correct", expectedCompanyName, actualCompanyName);
    }

    public void clickEditButton(){
        editCompanyButton.click();
    }

    public void clickUpdateButton(){
        updateButton.click();
    }

    public void clickLanguageUpdateButton(){
        languageUpdateButton.click();
    }

    public void clickUserProfile(){
        userProfileButton.click();
    }

    public void clickMainProfile(){
        mainProfileButton.click();
    }

    public void selectLanguage(String language) {
        Select languageSelect = new Select(languageListBox);
        //List<WebElement>  text = languageSelect.getOptions();
        //for (WebElement subElement : text) {
          //  System.out.println(subElement.getText());
        //}
        languageSelect.selectByValue("language." + language);
    }
}