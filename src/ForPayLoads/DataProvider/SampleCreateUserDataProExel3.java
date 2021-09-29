package ForPayLoads.DataProvider;

import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payLoad.SampleRequestsPayload.getSampleCreate;

public class SampleCreateUserDataProExel3 {

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
        XSSFSheet sheet = workbook.getSheet("AnotherSheet");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][2];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            XSSFCell name = row.getCell(0);
            if(name==null)
                data[i][0] ="";
            else {
                name.setCellType(CellType.STRING);
                data[i][0] = name.getStringCellValue();
            }

            XSSFCell job = row.getCell(1);
            if(job==null)
                data[i][1] ="";
            else {
                job.setCellType(CellType.STRING);
                data[i][1] = job.getStringCellValue();
            }


          /*  data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();*/
        }

        return data;
    }

}
