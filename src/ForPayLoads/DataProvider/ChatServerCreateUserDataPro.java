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
import static payLoad.ChatServerPayLoads.createUserPayLoadParam;

public class ChatServerCreateUserDataPro {

    @Test (dataProvider = "getData")
    public  void myTest(String username,String password,String email,String name,
                        String surname,String nickName)
    {

        RestAssured.baseURI = "http://chat.cookingwithamol.in";

                given().log().all()
                .auth().preemptive().basic("admin","admin123")
                 .header("Content-Type","application/json")
                        .body(createUserPayLoadParam(username,password
                        ,email,name,surname,nickName))

                .when().post("/index.php/site_admin/restapi/user")
                .then().log().all().assertThat().statusCode(400);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/myData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("chat user");
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<colCount;j++) {
                XSSFCell element = row.getCell(j);
                if (element == null)
                    data[i][j] = "";
                else {
                    element.setCellType(CellType.STRING);
                    data[i][j] = element.getStringCellValue();
                }
            }



        }

        return data;
    }
}
