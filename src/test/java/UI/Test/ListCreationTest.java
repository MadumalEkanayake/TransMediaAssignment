package UI.Test;

import org.assertj.core.api.SoftAssertions;
import Common.Constants;
import Pages.BoardsHomePage;
import Pages.ListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListCreationTest extends BaseUITest{
    SoftAssertions softAssertions = new SoftAssertions();
    // This test case verifies that two lists are created
    @Test
    public void ListCreation(){
        try {
            test = extent.createTest("UI TEST : Verify List Creation");

        BoardsHomePage boardsHomePage = new BoardsHomePage(driver);
        boardsHomePage.boardCreation();
        ListPage listPage = new ListPage(driver);
        String list1Name = listPage.createList1();
        String list2Name = listPage.createList2();
        softAssertions.assertThat(list1Name).isEqualTo(Constants.LISTNAME1);
        softAssertions.assertThat(list2Name).isEqualTo(Constants.LISTNAME2);
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

}
