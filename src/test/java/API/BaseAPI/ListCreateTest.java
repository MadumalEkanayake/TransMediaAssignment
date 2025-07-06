package API.BaseAPI;


import API.BaseAPI.Util.JsonFileRead;
import Common.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;


public class ListCreateTest extends BaseAPITest {

    // This test verifies successful Add list the API.
    @Test(description = "Verify that a user can Add List successfully and receives Valid Response.")
    public void postList() throws IOException {
        test = extent.createTest("API Test: Add List");
        try {

            // Load request payload from external JSON
            String requestBody = JsonFileRead.getPayloadByName("list_payload.json", "Add_list");


            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post("/lists")
                    .then()
                    .log().all()
                    .statusCode(201)
                    .body("name", equalTo("t4"))
                    .extract()
                    .response();


            test.pass("Received 201 Created and valid response");

            //Get the Location value from header

            String location = response.getHeader("Location");
            String LISTID = location.substring(location.lastIndexOf("/") + 1);

            //write location into util file
            try (FileWriter writer = new FileWriter(Constants.TEXTPATH)) {
                writer.write(LISTID);
            }

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


}

