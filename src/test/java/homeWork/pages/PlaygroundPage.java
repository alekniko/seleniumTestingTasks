package homeWork.pages;

import homeWork.core.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private final static By OK_BUTTON = By.linkText("OK");
    private final static By SUBMIT_BUTTON = By.id("submitbutton");
    private final static By CHECK_RESULT = By.id("checkresults");

    private BaseFunctions baseFunctions;

    public PlaygroundPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getPageTitle() {
        return baseFunctions.getElement(PAGE_TITLE).getText();
    }

    public void fillFirstSlot(String text) {
        baseFunctions.fillInputField(SLOT_1, text);
    }

    public void fillName(String text) {
        baseFunctions.fillInputField(NAME_FIELD, text);
    }

    public void setOccupation(String occupation) {
        baseFunctions.selectFromDropDown(OCCUPATION_DROPDOWN, occupation);
    }

    public Integer getBlueBoxCount() {
        return baseFunctions.getElements(BLUE_BOX).size();
    }

    public void fillFourthSlot(Integer count) {
        baseFunctions.fillInputField(SLOT_4, String.valueOf(count));
    }

    public void clickClickMeLink() {
        baseFunctions.clickElement(CLICK_ME_LINK);
    }

    public String getRedBoxClassName() {
        return baseFunctions.getElement(RED_BOX).getAttribute("class");
    }

    public void fillSixthSlot(String className) {
        baseFunctions.fillInputField(SLOT_6, className);
    }

    public void fillEighthSlot(String result) {
        baseFunctions.fillInputField(SLOT_8, result);
    }

    public String runJavaScript(String script) {
        return baseFunctions.runJavaScript(script);
    }

    public void selectBookWritten() {
        baseFunctions.clickElement(BOOK_WRITTEN_RADIO);
    }

    public String getRedBoxText() {
        return baseFunctions.getElement(RED_BOX).getText();
    }

    public void fillSlot10(String text) {
        baseFunctions.fillInputField(SLOT_10, text);
    }

    public boolean isGreenBoxOnTop() {
        List<WebElement> boxes = baseFunctions.getElements(ORANGE_OR_GREEN_BOXES);
        return boxes.get(0).getAttribute("id").equals("greenbox");
    }

    public void fillSlot11(String result) {
        baseFunctions.fillInputField(SLOT_11, result);
    }

    public boolean isItemOnThePage() {
        List<WebElement> item = baseFunctions.getElements(IS_HERE);
        return item.isEmpty();

    }

    public void fillSlot13(String result) {
        baseFunctions.fillInputField(SLOT_13, result);
    }

    public boolean isItemVisible() {
        return baseFunctions.getElement(IS_VISIBLE).isDisplayed();

    }

    public void fillSlot14(String result) {
        baseFunctions.fillInputField(SLOT_14, result);
    }

    public void clickClickThenWait() {
        baseFunctions.clickElement(CLICK_THEN_WAIT);
    }

    public void clickLinkAfterWait() {
        baseFunctions.clickElement(CLICK_AFTER_WAIT);
    }

    public void enter() {

        baseFunctions.pressEnter(OK_BUTTON, Keys.ENTER);
    }

    public void clickSubmit() {
        baseFunctions.clickElement(SUBMIT_BUTTON);
    }

    public void checkResult() {
        baseFunctions.clickElement(CHECK_RESULT);
    }


}
