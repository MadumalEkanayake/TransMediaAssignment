package Pages;

import Common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ListPage {

    WebDriver driver;

    //Locators for List page


    By boardTitleLocator = By.cssSelector("input[name='board-title']");
    By listNameInput = By.xpath("//input[@placeholder=\"Enter list title...\"]");
    By addlistButton = By.xpath("//button[contains(text(),'Add list')]");

    By addListTile = By.xpath("//div[@data-cy='create-list']");
    By listName = By.xpath("//input[@data-cy='list-name']");

    By listcardHandle = By.xpath("(//*[local-name()='svg']/parent::button[@data-cy='list-options'])[1]");

    By listDeletebtn = By.xpath("//div[@data-cy='delete-list']");

    private static final Logger logger = LoggerFactory.getLogger(BoardsHomePage.class);


    public ListPage(WebDriver driver) {
        this.driver = driver;
    }


    //Verify whether navigated into List page
    public boolean verifyNavigation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(boardTitleLocator));

        try {
            WebElement boardDetail = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(boardTitleLocator)
            );
            return boardDetail.isDisplayed();

        } catch (Exception e) {
            return false;
        }


    }

    //Creates two list
    public void createList() {
        //driver.findElement(AddListTile).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listNameInput));
        driver.findElement(listNameInput).sendKeys(Constants.LISTNAME1);
        driver.findElement(addlistButton).click();
        driver.findElement(listNameInput).sendKeys(Constants.LISTNAME2);
        driver.findElement(addlistButton).click();

    }

    //Returns list1 Name
    public String createList1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listNameInput));
        driver.findElement(listNameInput).sendKeys(Constants.LISTNAME1);
        driver.findElement(addlistButton).click();
        logger.info("List 1 created");
        return driver.findElement(addlistButton).getText();

    }

    //Returns list2 Name
    public String createList2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listNameInput));
        driver.findElement(listNameInput).sendKeys(Constants.LISTNAME2);
        driver.findElement(addlistButton).click();
        logger.info("List 2 created");
        return driver.findElement(addlistButton).getText();

    }


    //Deletes the created List
    public int deleteList() {
        driver.findElement(listcardHandle).click();
        driver.findElement(listDeletebtn).click();
        logger.info("Deleted the List 1");
        return driver.findElements(listName).size();


    }


}

