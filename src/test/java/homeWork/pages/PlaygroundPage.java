package homeWork.pages;

import homeWork.core.BaseFunctions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlaygroundPage {
    private final static By PAGE_TITLE = By.tagName("title");
    private final static By SLOT_1 = By.id("answer1");
    private final static By SLOT_4 = By.id("answer4");
    private final static By SLOT_6 = By.id("answer6");
    private final static By SLOT_8 = By.id("answer8");
    private final static By SLOT_10 = By.id("answer10");
    private final static By SLOT_11 = By.id("answer11");
    private final static By SLOT_13 = By.id("answer13");
    private final static By SLOT_14 = By.id("answer14");
    private final static By NAME_FIELD = By.id("name");
    private final static By OCCUPATION_DROPDOWN = By.id("occupation");
    private final static By BLUE_BOX = By.className("bluebox");
    private final static By CLICK_ME_LINK = By.linkText("click me");
    private final static By RED_BOX = By.id("redbox");
    private final static By BOOK_WRITTEN_RADIO = By.xpath("//input[@value = 'wrotebook']");
    private final static By ORANGE_OR_GREEN_BOXES = By.xpath("//span[@id = 'orangebox' or @id = 'greenbox']");
    private final static By IS_HERE = By.id("ishere");
    private final static By IS_VISIBLE = By.id("purplebox");
    private final static By CLICK_THEN_WAIT = By.linkText("click then wait");
    private final static By CLICK_AFTER_WAIT = By.linkText("click after wait");
    private final static By SUBMIT_BUTTON = By.id("submitbutton");
    private final static By CHECK_RESULT = By.id("checkresults");


    private BaseFunctions baseFunctions;
    private static final Logger LOGGER = LogManager.getLogger(PlaygroundPage.class);


    public PlaygroundPage(BaseFunctions baseFunctions) {
        LOGGER.info("Setting BaseFunctions to Playground page");
        this.baseFunctions = baseFunctions;
    }

    public String getPageTitle() {
        LOGGER.info("Getting page title");
        return baseFunctions.getElement(PAGE_TITLE).getText();
    }

    public void fillSlot1(String text) {
        LOGGER.info("Filling slot 1");
        baseFunctions.fillInputField(SLOT_1, text);
    }

    public void fillName(String text) {
        LOGGER.info("Filling authors name field");
        baseFunctions.fillInputField(NAME_FIELD, text);
    }

    public void setOccupation(String occupation) {
        LOGGER.info("Setting occupation");
        baseFunctions.selectFromDropDown(OCCUPATION_DROPDOWN, occupation);
    }

    public Integer getBlueBoxCount() {
        LOGGER.info("Getting blue box count");
        return baseFunctions.getElements(BLUE_BOX).size();
    }

    public void fillSlot4(Integer count) {
        LOGGER.info("Filling slot 4 with blue box count");
        baseFunctions.fillInputField(SLOT_4, String.valueOf(count));
    }

    public void clickClickMeLink() {
        LOGGER.info("Clicking on 'click me' link");
        baseFunctions.clickElement(CLICK_ME_LINK);
    }

    public String getRedBoxClassName() {
        LOGGER.info("Getting blue box class name");
        return baseFunctions.getElement(RED_BOX).getAttribute("class");
    }

    public void fillSlot6(String className) {
        LOGGER.info("Filling slot 6 with blue box class name");
        baseFunctions.fillInputField(SLOT_6, className);
    }

    public String runJavaScript(String script) {
        LOGGER.info("Starting JavaScript");
        return baseFunctions.runJavaScript(script);
    }

    public void fillSlot8(String result) {
        LOGGER.info("Filling slot 8 with JavaScript 2 result");
        baseFunctions.fillInputField(SLOT_8, result);
    }


    public void selectBookWritten() {
        LOGGER.info("Selecting radio button");
        baseFunctions.clickElement(BOOK_WRITTEN_RADIO);
    }

    public String getRedBoxText() {
        LOGGER.info("Getting text from red box");
        return baseFunctions.getElement(RED_BOX).getText();
    }

    public void fillSlot10(String text) {
        LOGGER.info("Filling slot 10 with text from red box");
        baseFunctions.fillInputField(SLOT_10, text);
    }

    public boolean isGreenBoxOnTop() {
        LOGGER.info("Checking if green box is on top");
        List<WebElement> boxes = baseFunctions.getElements(ORANGE_OR_GREEN_BOXES);
        return boxes.get(0).getAttribute("id").equals("greenbox");
    }

    public void fillSlot11(String result) {
        LOGGER.info("Filling slot 11 with color of box on top");
        baseFunctions.fillInputField(SLOT_11, result);
    }

    public boolean isItemOnThePage() {
        LOGGER.info("Checking if item is on the page");
        List<WebElement> item = baseFunctions.getElements(IS_HERE);
        return item.isEmpty();

    }

    public void fillSlot13(String result) {
        LOGGER.info("Filling slot 13 with result: is item on the page or not");
        baseFunctions.fillInputField(SLOT_13, result);
    }

    public boolean isItemVisible() {
        LOGGER.info("Checking if purple box is visible on the page");
        return baseFunctions.getElement(IS_VISIBLE).isDisplayed();

    }

    public void fillSlot14(String result) {
        LOGGER.info("Filling slot 14 with result: is purple box visible on the page or not");
        baseFunctions.fillInputField(SLOT_14, result);
    }

    public void clickClickThenWait() {
        LOGGER.info("Clicking on the link 'click then wait'");
        baseFunctions.clickElement(CLICK_THEN_WAIT);
    }

    public void clickLinkAfterWait() {
        LOGGER.info("Clicking on the new appeared link 'click after wait'");
        baseFunctions.clickElement(CLICK_AFTER_WAIT);
    }

    public void clickSubmit() {
        LOGGER.info("Clicking on Submit button");
        baseFunctions.clickElement(SUBMIT_BUTTON);
    }

    public void checkResult() {
        LOGGER.info("Clicking on 'Check Result!' button");
        baseFunctions.clickElement(CHECK_RESULT);
    }


}
