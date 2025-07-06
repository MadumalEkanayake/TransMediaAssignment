package UI.Test;

import Pages.BoardsHomePage;
import Pages.ListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends BaseUITest {


    // This test case verifies landing of the Boards Page
    @Test(priority = 0)
    public void testBoardVisibility() {
        try {
            test = extent.createTest("UI TEST : Landing in BoardHome");
            BoardsHomePage boardsPage = new BoardsHomePage(driver);
            String headerText = boardsPage.boardPageVerify();
            Assert.assertEquals(headerText, "My Boards");
            test.pass("Navigated to board creation screen");
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }

    }


    // This test case verifies that new board created and landed inside of the board
    @Test(priority = 1)
    public void verifyBoardCreation() throws InterruptedException {
        try {
            test = extent.createTest("UI TEST : Verify Board Creation");
            BoardsHomePage boardsHomePage = new BoardsHomePage(driver);
            boardsHomePage.boardCreation();
            ListPage listPage = new ListPage(driver);
            Assert.assertTrue(listPage.verifyNavigation());
            test.pass("Board created");
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }

    }


}
