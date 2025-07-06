package API.BaseAPI;

import Common.Constants;
import Common.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;


public class BaseAPITest {

    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }

    //Initializes the base configuration for API tests by setting the base URI,API key and Content type
    @BeforeMethod
    public void setup() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(Constants.BASE_URI)
                .addHeader("Content-Type", "application/json")
                .build();

        RestAssured.requestSpecification = requestSpec;
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

}
