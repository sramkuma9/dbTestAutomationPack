package bni.regression.pageFactory;

import bni.regression.libraries.common.ReadWritePropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BNIConnect {
    public static WebDriver driver;
    public WebDriverWait wait;
    private ReadWritePropertyFile readWritePropertyFile = new ReadWritePropertyFile();

    @FindBy(css = "#accountNav_2 > p > a")
    WebElement options;

    @FindBy(css = "#accountNav_2 > ul > li:nth-child(3) > a")
    WebElement signOut;

    @FindBy(css = "#footer > div:nth-child(2) > a:nth-child(3)")
    WebElement signOutFooter;

    @FindBy(css = "#bniCountry")
    WebElement countryListBox;

    @FindBy(css = "#translationIcon")
    WebElement tButton;

    @FindBy(css = "#nav > a.help")
    WebElement helpButton;

    @FindBy (css=".searchpeople")
    WebElement searchPeople;


    @FindBy(css = "#showDroppedMembersRegionalPALMSReportDisplay")
    WebElement showDroppedMemberCheckBox;

    @FindBy(css = "#trackingPALMSRegionalPALMSReportDisplay")
    WebElement trackingPalmsCheckBox;

    @FindBy(css = "#commonFilterListCountries > div > a")
    List<WebElement> countrySelect;

    @FindBy(css = "#bniRegion")
    WebElement regionListBox;

    @FindBy(css = "#commonFilterListRegions > div > a")
    List<WebElement> regionSelect;

    @FindBy(css = "#bniChapter")
    WebElement chapterListBox;

    @FindBy(css = "#commonFilterListChapters > div > a")
    List<WebElement> chapterSelect;

    @FindBy(css = "#textnav > li")
    List<WebElement> menuNavigate;

    @FindBy(css = "#textnav > li > ul > li")
    List<WebElement> subMenuNavigate;

    @FindBy(css = "#help")
    List<WebElement> subListMenu;

    @FindBy(css = "#help")
    List<WebElement> mainListMenu;



    @FindBy(css="#datalist1 > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)")
    WebElement membershipLink;

    @FindBy(css = "#help")
    List<WebElement> reportsViewActionsByMenu;

    @FindBy(css = "#droppedMemberEmail")
    WebElement emailTextBox;

    @FindBy(css = "#searchDroppedMember")
    WebElement searchButton;

    //@FindBy(css = "#convertToMemberHref")
    @FindBy(css = "#convertToMemberHrefCofC")
    WebElement addButton;

    @FindBy(css = "#convertToMemberHref")
    WebElement addProspectButton;

    @FindBy(css = "#columnlinks > a:nth-child(5)")
    WebElement renewNowLink;

    @FindBy(css = "#lpUlTabs > li")
    List<WebElement> leftSideMenu;

    @FindBy(css = "#listevents > div")
    List<WebElement> eventLists;

    @FindBy(css = "#datalist1 > tbody > tr")
    List<WebElement> typeLink;

    @FindBy(css = "#footer > div.copyright > p:nth-child(1)")
    WebElement buildNumber;

    @FindBy(css = "#startCountryDateMembershipFeesReportDisplay_Country")
    WebElement effectiveDateTextBox;

    @FindBy(css = "#footer > div.copyright > p:nth-child(3) > a:nth-child(2)")
    WebElement privacyPolicyLink;

    @FindBy(css = "#button_Country")
    WebElement goCountryButton;

    @FindBy(css = "#regional_PALMSReport > div > input")
    WebElement goRegionButton;

    @FindBy(css = "#chapter_Membership_Dues_Report_Form > div > input")
    WebElement goChapterButton;

    @FindBy(css = "#hq_exit_interview_report > div > input")
    WebElement goHqButton;

    @FindBy(css = "#footer > div.copyright > p:nth-child(3) > a:nth-child(3)")
    WebElement browserPolicyLink;

    @FindBy(css = "#ui-datepicker-div > table > tbody > tr")
    List<WebElement> datePicker;

    @FindBy(css = "#ui-datepicker-div > div > div > select.ui-datepicker-month")
    WebElement Month;

    @FindBy(css = "#ui-datepicker-div > div > div > select.ui-datepicker-year")
    WebElement Year;

    @FindBy(css = "#startHQDateExitInterviewDisplay")
    WebElement startDateTextBox;

    @FindBy(css = "#endHQDateExitInterviewDisplay")
    WebElement endDateTextBox;

    @FindBy(css = "#exportWithoutHeadersreports_exit_interview")
    WebElement exportWithoutHeadersCheckBox;

    @FindBy(css = "#startDateRegionalPALMSReportDisplay")
    WebElement startDateForRegionReport;

    @FindBy(css = "#endDateRegionalPALMSReportDisplay")
    WebElement endDateForRegionReport;

    @FindBy(css = "#endDateChapterMembershipDuesReportDisplay")
    WebElement reportDateTextBox;

    @FindBy(css = "#regionsRegionalPALMSReport")
    List<WebElement> regionList;

    @FindBy(css="#tabs-3-5 > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)")
    WebElement manageProspectLink;

    @FindBy(css="#footer > div.copyright > p:nth-child(1)")
    WebElement copyRightArea;

    public BNIConnect(WebDriver driver) {
        BNIConnect.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        //This initElements method will create all WebElements
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void checkTextInFooter(String concept){
        String[] splitFooter = copyRightArea.getText().split("\n");
        if (concept.equals("CC")){
            assertEquals("Branding text is not correct for CC type.", "Copyright 2018 CorporateConnections™. All Rights Reserved.", splitFooter[0]);
        }else{
            assertEquals("Branding text is not correct for BNI type.", "Copyright 2018 BNI. All Rights Reserved.", splitFooter[0]);
        }
    }

    public void checkPrivacyPolicyTranslation(String expPrivacyPolicy){
        String actualPrivacyPolicy = privacyPolicyLink.getText();
        assertEquals("Privacy Policy translation is not correct", expPrivacyPolicy, actualPrivacyPolicy);
    }

    public void checkBrowserPolicyTranslation(String expBrowserPolicy){
        String actualBrowserPolicy = browserPolicyLink.getText();
        assertEquals("Browser Policy translation is not correct", expBrowserPolicy, actualBrowserPolicy);
    }

    public void hoverOnOptions() {
        Actions action = new Actions(driver);
        action.moveToElement(options);
        action.build().perform();
    }

    public void clickTIcon(){
        tButton.click();
    }


    public void clickHelpIcon(){
        helpButton.click();
    }

    public void clickGoCountryButton(){
        goCountryButton.click();
    }

    public void clickGoHqButton(){
        goHqButton.click();
    }

    public void clickGoChapterButton(){
        goChapterButton.click();
    }

    public void clickGoRegionButton(){
        goRegionButton.click();
    }

    public void clickShowDroppedMemberCheckBox(){
        showDroppedMemberCheckBox.click();
    }

    public void clickTrackingPalmsCheckBox(){
        trackingPalmsCheckBox.click();
    }

    public void clickMagnifyingGlass(){
        searchPeople.click();
    }

    public void clickMembershipLink(){
        membershipLink.click();
    }


    public void clickStartDateTextBox(){
        startDateTextBox.click();
    }

    public void clickStartDateForReportTextBox(){
        startDateForRegionReport.click();
    }

    public void clickEndDateForReportTextBox(){
        endDateForRegionReport.click();
    }

    public void clickEndDateTextBox(){
        endDateTextBox.click();
    }

    public void selectCountry(String country) throws InterruptedException {
        int counter = 0;
        Actions action = new Actions(driver);
        countryListBox.click();
        TimeUnit.SECONDS.sleep(2);
        for (WebElement divElement : countrySelect) {
            List<WebElement> a_collection = divElement.findElements(By.tagName("span"));
            String countryName = a_collection.get(0).getText();
            if (country.equals(countryName)){
                action.moveToElement(a_collection.get(0));
                action.build().perform();
                a_collection.get(0).click();
                counter++;
                break;
            }if (counter == 1) {
                break;
            }
        }
    }

    public void selectRegion(String region) throws InterruptedException {
        int counter = 0;
        Actions action = new Actions(driver);
        regionListBox.click();
        TimeUnit.SECONDS.sleep(2);
        for (WebElement divElement : regionSelect) {
            List<WebElement> a_collection = divElement.findElements(By.tagName("span"));
            String regionName = a_collection.get(0).getText();
            if (region.equals(regionName)){
                action.moveToElement(a_collection.get(0));
                action.build().perform();
                a_collection.get(0).click();
                counter++;
                break;
            }if (counter == 1) {
                break;
            }
        }
    }

    public void selectChapter(String chapter) throws InterruptedException {
        int counter = 0;
        Actions action = new Actions(driver);
        chapterListBox.click();
        TimeUnit.SECONDS.sleep(2);
        for (WebElement divElement : chapterSelect) {
            List<WebElement> a_collection = divElement.findElements(By.tagName("span"));
            String chapterName = a_collection.get(0).getText();
            if (chapter.equals(chapterName)){
                action.moveToElement(a_collection.get(0));
                action.build().perform();
                a_collection.get(0).click();
                counter++;
                break;
            }if (counter == 1) {
                break;
            }
        }
    }

    public void navigateMenu(String menuItem) throws Exception {
        String[] menusplit = menuItem.split(",");
        int size = menusplit.length;
        Actions action = new Actions(driver);
        int counter = 0;
        for (WebElement trElement : menuNavigate) {
            List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
            String menuName = td_collection.get(0).getText();
            if (menusplit[0].equals(menuName)) {
                switch (size) {
                    case 1:
                        TimeUnit.SECONDS.sleep(3);
                        td_collection.get(0).click();
                        break;
                    case 2:
                        TimeUnit.SECONDS.sleep(3);
                        action.moveToElement(td_collection.get(0));
                        action.build().perform();
                        TimeUnit.SECONDS.sleep(3);
                        //td_collection.findElement(By.tagName("a"));
                        for (WebElement subElement : subMenuNavigate) {
                            List<WebElement> sub_collection = subElement.findElements(By.tagName("a"));
                            String subMenuName = sub_collection.get(0).getText();
                            if (menusplit[1].equals(subMenuName)) {
                                sub_collection.get(0).click();
                                counter = counter + 1;
                                break;
                            }
                        }
                        break;
                    case 3:
                        TimeUnit.SECONDS.sleep(3);
                        action.moveToElement(td_collection.get(0));
                        action.build().perform();
                        TimeUnit.SECONDS.sleep(3);
                        for (WebElement subElement : subMenuNavigate) {
                            List<WebElement> sub_collection = subElement.findElements(By.tagName("a"));
                            String subMenuName = sub_collection.get(0).getText();
                            if (menusplit[1].equals(subMenuName)) {
                                sub_collection.get(0).click();
                                counter = counter + 1;
                                break;
                            }
                        }
                        TimeUnit.SECONDS.sleep(4);
                        this.selectItemFromMainListMenu(menusplit[1]);
                        TimeUnit.SECONDS.sleep(5);
                        this.selectItemFromSubListMenu(menusplit[2]);
                        break;
                }
            }
            if (counter == 1) {
                break;
            }
        }
    }

    public void selectItemFromSubListMenu(String item) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        for (WebElement trElement : subListMenu) {
            List<WebElement> td_collection = trElement.findElements(By.tagName("tbody"));
            String menuItem = td_collection.get(0).findElement(By.tagName("tr")).getText();
            if (item.equals(menuItem)) {
                td_collection.get(0).findElement(By.tagName("tr")).findElement(By.tagName("a")).click();
                TimeUnit.SECONDS.sleep(3);
                break;
            }
        }
    }

    public void selectItemFromMainListMenu(String item) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        for (WebElement trElement : mainListMenu) {
            List<WebElement> td_collection = trElement.findElements(By.tagName("tbody"));
            String menuItem = td_collection.get(0).findElement(By.tagName("tr")).getText();
            if (item.equals(menuItem)) {
                td_collection.get(0).findElement(By.tagName("tr")).findElement(By.tagName("a")).click();
                TimeUnit.SECONDS.sleep(3);
                break;
            }
        }
    }

    public void selectItemFromReportsViewActionsByMenu(String item) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        for (WebElement trElement : reportsViewActionsByMenu) {
            List<WebElement> td_collection = trElement.findElements(By.tagName("tbody"));
            String menuItem = td_collection.get(0).findElement(By.tagName("tr")).getText();
            if (item.equals(menuItem)) {
                td_collection.get(0).findElement(By.tagName("tr")).findElement(By.tagName("a")).click();
                TimeUnit.SECONDS.sleep(3);
                break;
            }
        }
    }

    public void selectItemFromLeftSideMenu(String item) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        for (WebElement trElement : leftSideMenu) {
            List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
            String menuItem = td_collection.get(0).getText();
            if (item.equals(menuItem)) {
                td_collection.get(0).click();
                TimeUnit.SECONDS.sleep(3);
                break;
            }
        }
    }

    public void selectItemFromEventLists(String item) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        for (WebElement trElement : eventLists) {
            List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
            String menuItem = td_collection.get(0).getText();
            if (item.equals(menuItem)) {
                td_collection.get(0).click();
                TimeUnit.SECONDS.sleep(3);
                break;
            }
        }
    }

    public void enterEmailId(String emailId) {
        emailTextBox.sendKeys(emailId);

    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public  void clickAddButton(){
        addButton.click();
    }

    public  void clickAddProspectButton(){
        addProspectButton.click();
    }

    public  void clickEffectiveDateTextBox(){
        effectiveDateTextBox.click();
    }

    public  void clickReportDateTextBox(){
        reportDateTextBox.click();
    }

    public  void clickExportWithoutHeadersCheckBox(){
        exportWithoutHeadersCheckBox.click();
    }

    public void clickSignOut() throws Exception {
        signOut.click();
        TimeUnit.SECONDS.sleep(5);
    }

    public void clickManageProspect() throws InterruptedException{
        manageProspectLink.click();
        TimeUnit.SECONDS.sleep(2);
    }
    public void clickSignOutFooter() throws Exception {
        signOutFooter.click();
        TimeUnit.SECONDS.sleep(5);
    }

    public  void clickRenewNowLink(){
        renewNowLink.click();
    }

    public void clickTypeLink(String item) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        for (WebElement trElement : typeLink) {
            List<WebElement> td_collection = trElement.findElements(By.tagName("td"));
            String typeItem = td_collection.get(1).getText();
            if (item.equals(typeItem)) {
                td_collection.get(1).findElement(By.tagName("a")).click();
                TimeUnit.SECONDS.sleep(3);
                break;
            }
        }
    }

    public void checkBuildNumber(String expBuildNumber){
        String[] splitBuildNumber = buildNumber.getText().split("\n");
        String [] acutualBuildNumber = splitBuildNumber[1].split(",");
        assertEquals("Build number is not correct...", expBuildNumber,acutualBuildNumber[0]);
    }

    public void selectDateFromDatePicker(String day) throws Exception{
        Integer breaker = 2;
        for(WebElement trElement : datePicker)
        {
            List<WebElement> td_collection=trElement.findElements(By.tagName("td"));
            for (int row = 0; row < 7; row++) {
                String dayItem = td_collection.get(row).getText();
                if (day.equals(dayItem)) {
                    td_collection.get(row).findElement(By.tagName("a")).click();
                    TimeUnit.SECONDS.sleep(3);
                    breaker++;
                    break;
                }
            }
            if (breaker==3) {
                break;
            }
        }
    }

    public void selectMonth(String month) {
        Select MonthSelect = new Select(Month);
        MonthSelect.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select YearSelect = new Select(Year);
        YearSelect.selectByVisibleText(year);
    }

    public void selectRegionForReport(String region) {
        for (WebElement trElement : regionList) {
            List<WebElement> td_collection = trElement.findElements(By.tagName("option"));
            Integer listSize = td_collection.size();
            for (int i = 0; i < listSize; i++) {
                String regionItem = td_collection.get(i).getText();
                if (region.equals(regionItem)) {
                    td_collection.get(i).click();
                    break;
                }
            }
        }
    }
}
