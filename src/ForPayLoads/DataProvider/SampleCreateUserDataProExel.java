package ForPayLoads.DataProvider;

import io.restassured.RestAssured;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payLoad.SampleRequestsPayload.getSampleCreate;

public class SampleCreateUserDataProExel {

    @Test(dataProvider = "getData")
    public  void myTest(String name,String job)
    {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(getSampleCreate(name,job))
                .post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/myData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];

        for(int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);
            data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
        }

        return data;
    }

}
