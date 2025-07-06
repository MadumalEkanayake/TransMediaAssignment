package UI.Test;

import Common.Constants;
import Pages.BoardsHomePage;
import Pages.ListPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListDeletionTest extends BaseUITest{

    SoftAssertions softAssertions = new SoftAssertions();

    // This test case verifies if one of the lists is deleted
    @Test
    public void ListDeletion(){
        try {
            test = extent.createTest("UI TEST : Verify List Deletion");
        BoardsHomePage boardsHomePage = new BoardsHomePage(driver);
        boardsHomePage.boardCreation();
        ListPage listPage = new ListPage(driver);
        String list1Name = listPage.createList1();
        String list2Name = listPage.createList2();
        softAssertions.assertThat(list1Name).isEqualTo(Constants.LISTNAME1);
        softAssertions.assertThat(list2Name).isEqualTo(Constants.LISTNAME2);
        int listSize = listPage.deleteList();
        softAssertions.assertThat(listSize).isEqualTo(1);
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

}
