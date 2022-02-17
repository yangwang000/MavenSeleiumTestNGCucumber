package com.ada.utils.DataPropertiesOperation;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HybridExecuteTest {
    WebDriver webdriver = null;

    @Test(dataProvider = "hybridData")
    public void testLogin(String testcaseName, String keyword, String objectName, String objectType, String value) throws Exception {
        // TODO Auto-generated method stub

        if (testcaseName != null && testcaseName.length() != 0) {
            String driverPath = "/Users/yangwang/Documents/Utils/chromedriver";
            System.setProperty("webdriver.chrome.driver", driverPath);
            webdriver = new ChromeDriver();
        }
        UIOperation operation = new UIOperation(webdriver);
        //Call perform function to perform operation on UI
//        operation.perform(allObjects, keyword, objectName,
//                objectType, value);

    }

    @DataProvider(name = "hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        ReadExcelFile file = new ReadExcelFile();
//Read keyword sheet
        Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir"), "TestCase.xlsx", "KeywordFramework");
//Find number of rows in excel file
        int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
        object = new Object[rowCount][5];
        for (int i = 0; i < rowCount; i++) {
            //Loop over all the rows
            Row row = guru99Sheet.getRow(i + 1);
            //Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print excel data in console
                object[i][j] = row.getCell(j).toString();
            }
        }
        System.out.println("");
        return object;
    }
}
