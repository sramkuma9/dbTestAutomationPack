package bni.regression.steps.endToEndIntegrationSteps;

import bni.regression.libraries.api.RestApiClient;
import bni.regression.libraries.common.*;
import bni.regression.libraries.common.email.GmailClient;
import bni.regression.libraries.db.DbConnect;
import bni.regression.libraries.db.DbXlsComparator;
import cucumber.api.java.en.Given;

public class TestAndDelete {
    ReadWriteExcel readWriteExcel = new ReadWriteExcel();
    DbConnect dbConnect = new DbConnect();
    private ReadWritePropertyFile readWritePropertyFile = new ReadWritePropertyFile();
    ReadPDFReader readPDFReader = new ReadPDFReader();
    SearchAndReturnFileName searchAndReturnFileName = new SearchAndReturnFileName();
    SearchAndDeleteFile searchAndDeleteFile = new SearchAndDeleteFile();
    GmailClient gmailClient = new GmailClient();
    RestApiClient restApiClient = new RestApiClient();
    DbXlsComparator dbXlsComparator = new DbXlsComparator();
    DeleteAndCopyConfigFile deleteAndCopyConfigFile = new DeleteAndCopyConfigFile();

    @Given("test and delete")
    public void test_and_delete() throws Exception {
        //readWriteExcel.setExcelFile("src/test/resources/inputFiles/testInput.xlsx");
        //boolean setFlag = readWriteExcel.deleteRow("src/test/resources/inputFiles/testInput.xlsx", "addBrandNewVisitor", 0);
        //boolean setFlag1 = readWriteExcel.deleteRow("src/test/resources/inputFiles/testInput.xlsx", "addBrandNewVisitor", 1);
//        String[][] sqlResult = dbConnect.queryAndRetrieveRecords(readWritePropertyFile.loadAndReadPropertyFile("addAVisitor1", "properties/sql.properties"));
//        rtestInputFilePatheadWriteExcel.setExcelFile("src/test/resources/inputFiles/testAndDelete.xlsx");
//        Integer xlsRowCount = readWriteExcel.getRowCount("addBrandNewVisitor");
//        String[][] xlsData = readWriteExcel.returnDataForDbXlsComparatorClass("addBrandNewVisitor");
//        dbXlsComparator.resultComparator(sqlResult, xlsData,xlsRowCount);
        //searchAndRenameFile.searchFileAndRename("/home/ajay/Downloads/test","del",".xls");
        //searchAndDeleteFile.searchFileAndDelete("/home/ajay/Downloads/","FindAPersonReport",".xls");
       //gmailClient.checkEmail("shanthibni@gmail.com","BNI- Your registration is successful for TestAutomation20191204134548","shanthibni+32@gmail.com");
       // gmailClient.checkEmail("shanthibni@gmail.com","email verification","shanthibni+45@gmail.com");
//        gmailClient.checkEmail("dbselenium@gmail.com","Fwd: You've visited.....would you now like to join us?","dbselenium@gmail.com","applicant");
        //restApiClient.apiGetClient("testApi");
        //readWriteExcel.setExcelFile("src/test/resources/inputFiles/testAndDelete.xlsx");
        //String[][] xlsData = readWriteExcel.returnDataForDbXlsComparatorClass("addBrandNewVisitor");
        //System.out.println("success");
    }
}
