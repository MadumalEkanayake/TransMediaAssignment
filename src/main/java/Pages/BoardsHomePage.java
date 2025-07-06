package Pages;

import Common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardsHomePage {

    WebDriver driver;

    // Locators for Board Homepage elements
    private By boardHeader = By.xpath("//h1[text()=' My Boards ']");
    private By boardHover = By.xpath("//div[@class=\"create-board hover:bg-gray7\"]");
    private By boardTitleTextBox = By.xpath("//input[@placeholder=\"Add board title\"]");

    private static final Logger logger = LoggerFactory.getLogger(BoardsHomePage.class);

    public BoardsHomePage(WebDriver driver) {
        this.driver = driver;

    }


    //Verification for landed in the Boards page
    public String boardPageVerify() {
        String headerText = driver.findElement(boardHeader).getText();
        logger.info("Board page header text found: {}", headerText);
        return headerText;


    }

    //Creates a new Board
    public void boardCreation() {
        driver.findElement(boardHover).click();
        logger.info("Clicking on the board creation element.");
        driver.findElement(boardTitleTextBox).sendKeys(Constants.BOARD_NAME + Keys.ENTER);


    }

}
