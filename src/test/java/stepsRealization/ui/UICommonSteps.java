package stepsRealization.ui;

import helpers.FileWriterReader;
import helpers.RandomUserHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.GoogleResultsPage;
import pages.GoogleSearchPage;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class UICommonSteps {

    private static Logger log = Logger.getLogger(UICommonSteps.class.getName());
    private RandomUserHelper randomUserHelper = new RandomUserHelper();
    private FileWriterReader fileWriterReader = new FileWriterReader();

    private GoogleSearchPage googleSearchPage;
    private GoogleResultsPage googleResultsPage;

    public UICommonSteps(WebDriver driver) {
        googleSearchPage = new GoogleSearchPage(driver);
        googleResultsPage = new GoogleResultsPage(driver);

    }

    public void openGoogleSearchPage() {
        log.info("Trying to open Google Search page");
        googleSearchPage.openGoogleSearchPage();
        googleSearchPage.waitGooglePageLoad();
    }

    public void inputUserNameFromResponseInSearchField() {
        String name = randomUserHelper.getUserNameFromContextRespose();
        log.info(String.format("Searching for user %s ...", name));
        googleSearchPage.inputTextInSearchField(name);
    }

    public void clickGoogleSearchButton() {
        googleSearchPage.googleSearchButtonClick();
    }

    public boolean isGoogleResultPageLoaded() {
        return googleResultsPage.isPageDisplayed();
    }

    public boolean isLinkWithUserNamePresent() {
        List<WebElement> links = googleResultsPage.getLinksOnPage();
        return links.stream().anyMatch(n -> n.getText().contains("www.facebook.com"));
    }

    public void inputRandomUserNameFromFileInSearchField() {
        try {
            int amountOfNamesInFile = fileWriterReader.getCountOfRows("Users");
            int i = new Random().nextInt(amountOfNamesInFile) + 1;
            String randomName = fileWriterReader.readPropertyById(i, "Users");
            log.info(String.format("Searching for the %d-th user from file. Name from file: %s ...", i, randomName));
            googleSearchPage.inputTextInSearchField(randomName);
        } catch (InvalidFormatException | IOException e) {
            log.severe("Something went wrong while working with file...");
            throw new RuntimeException(e);
        }
    }
}
