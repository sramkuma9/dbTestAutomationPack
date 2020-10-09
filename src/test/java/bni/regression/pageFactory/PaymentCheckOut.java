package bni.regression.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class PaymentCheckOut {
    public static WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//*[@name='CardNumber']")
    WebElement cardNumberTextBox;

    @FindBy(xpath = "//*[@name='CardHolderName']")
    WebElement nameOnCardTextBox;

    @FindBy(xpath = "//*[@name='Cvc2']")
    WebElement cvcTextBox;

    @FindBy(css = "#DateExpiry_1")
    WebElement expiryDateMonth;

    @FindBy(css = "#DateExpiry_2")
    WebElement expiryDateYear;

    @FindBy(xpath = "//*[@name='Add']")
    WebElement submitButton;

    @FindBy(css = "#Success")
    WebElement transactionStatus;

    @FindBy(xpath = "/html/body/div[2]/form/div[4]/div/fieldset/a")
    WebElement nextButton;

    public PaymentCheckOut(WebDriver driver) {
        PaymentCheckOut.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        //This initElements method will create all WebElements
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void enterCardNumber(String cardNumber){
        cardNumberTextBox.sendKeys(cardNumber);
    }

    public void enterNameOnCard(String name){
        nameOnCardTextBox.sendKeys(name);
    }

    public void enterCvc(String cvc){
        cvcTextBox.sendKeys(cvc);
    }

    public void selectExpiryDateMonth(String month){
        Select expiryDateSelect = new Select(expiryDateMonth);
        expiryDateSelect.selectByVisibleText(month);
    }

    public void selectExpiryDateYear(String year){
        Select expiryDateSelect = new Select(expiryDateYear);
        expiryDateSelect.selectByVisibleText(year);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void checkTransactionStatus(){
        Boolean status = transactionStatus.isDisplayed();
        assertEquals("payment transaction failed...", true, status);
    }
}
