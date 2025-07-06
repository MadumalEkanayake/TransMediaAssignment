package API.BaseAPI;

import Common.Constants;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ListDeleteTest extends BaseAPITest {

    // This test verifies successful Delete list.
    @Test(description = "Verify that a user can Delete List successfully.")
    public void deleteList() throws IOException {

        test = extent.createTest("API Test: Delete List");

        try {

            String listId = Files.readString(Paths.get(Constants.TEXTPATH)).trim();


            given()
                    .pathParam("id", listId)
                    .when()
                    .delete("/lists/{id}")
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .body(equalTo("{}"));

            test.pass("Received 200 valid response");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
