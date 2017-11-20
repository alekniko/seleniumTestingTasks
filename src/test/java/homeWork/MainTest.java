package homeWork;


import homeWork.core.BaseFunctions;
import homeWork.pages.PlaygroundPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class MainTest {

    private BaseFunctions baseFunctions = new BaseFunctions();

    private static final Logger LOGGER = LogManager.getLogger(MainTest.class);
    private static final String TEST_PAGE = "http://timvroom.com/selenium/playground/";
    private static final String USER_NAME = "Kilgore Trout";
    private static final String OCCUPATION = "Science Fiction Author";
    private static final String SCRIPT_1 = "ran_this_js_function()";
    private static final String SCRIPT_2 = "return got_return_from_js_function()";
    private static final int WIDTH = 850;
    private static final int HEIGHT = 650;
    

    @Test
    public void MainTest() {

        LOGGER.info("Open the page with tasks");
        baseFunctions.goToURL(TEST_PAGE);
        PlaygroundPage playgroundPage = new PlaygroundPage(baseFunctions);

        LOGGER.info("1: Grab page title and place title text in answer slot #1");
        String title = playgroundPage.getPageTitle();
        playgroundPage.fillFirstSlot(title);

        LOGGER.info("2: Fill out name section of form to be Kilgore Trout");
        playgroundPage.fillName(USER_NAME);

        LOGGER.info("3: Set occupation on form to Sci-Fi Author");
        playgroundPage.setOccupation(OCCUPATION);

        LOGGER.info("4: Count number of blue_boxes on page after form and enter into answer box #4");
        Integer blueBoxCount = playgroundPage.getBlueBoxCount();
        playgroundPage.fillFourthSlot(blueBoxCount);

        LOGGER.info("5: Click link that says 'click me'");
        playgroundPage.clickClickMeLink();

        LOGGER.info("6: Find red box on its page find class applied to it, and enter into answer box #6");
        String className = playgroundPage.getRedBoxClassName();
        playgroundPage.fillSixthSlot(className);

        LOGGER.info("7: Run JavaScript function as: ran_this_js_function() from your Selenium script");
        playgroundPage.runJavaScript(SCRIPT_1);

        LOGGER.info("8: Run JavaScript function as: got_return_from_js_function() from your Selenium script, take returned value and place it in answer slot #8");
        String result = playgroundPage.runJavaScript(SCRIPT_2);
        playgroundPage.fillEighthSlot(result);


        LOGGER.info("9: Mark radio button on form for written book to Yes");
        playgroundPage.selectBookWritten();

        LOGGER.info("10: Get the text from the Red Box and place it in answer slot #10");
        String redBoxText = playgroundPage.getRedBoxText();
        playgroundPage.fillSlot10(redBoxText);

        LOGGER.info("11: Which box is on top? orange or green -- place correct color in answer slot #11");
        if (playgroundPage.isGreenBoxOnTop()) {
            playgroundPage.fillSlot11("green");
        } else {
            playgroundPage.fillSlot11("orange");
        }

        LOGGER.info("12: Set browser width to 850 and height to 650");
        baseFunctions.changeWindowSize(WIDTH, HEIGHT);

        LOGGER.info("Type into answer slot 13 yes or no depending on whether item by id of ishere is on the page");
        if (playgroundPage.isItemOnThePage()) {
            playgroundPage.fillSlot13("no");
        } else {
            playgroundPage.fillSlot13("yes");
        }
        LOGGER.info("Type into answer slot 14 yes or no depending on whether item with id of purplebox is visible");
        if (playgroundPage.isItemVisible()) {
            playgroundPage.fillSlot14("yes");
        } else {
            playgroundPage.fillSlot14("no");
        }
        LOGGER.info("Waiting game: click the link with link text of 'click then wait' a random wait will occur (up to 10 seconds) " +
                "and then a new link will get added with link text of 'click after wait' - click this new link within 500 ms of it appearing to pass this test");
        playgroundPage.clickClickThenWait();
        baseFunctions.implicityWait();
        playgroundPage.clickLinkAfterWait();

        LOGGER.info("Click OK on the confirm after completing task 15");
        baseFunctions.pressEnter();

        LOGGER.info("Click the submit button on the form");
        playgroundPage.clickSubmit();

        LOGGER.info("Checking results");
        playgroundPage.checkResult();

    }
}
