package stepsRealization.ui;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.GoogleResultsPage;
import pages.GoogleSearchPage;
import java.util.List;
import java.util.logging.Logger;

public class UICommonSteps {
    private GoogleSearchPage googleSearchPage;
    private GoogleResultsPage googleResultsPage;
    private static Logger log = Logger.getLogger(UICommonSteps.class.getName());

    public boolean checkForUserInFacebook(WebDriver driver, String name) {
        initializeGoogleSearchPage(driver);
        searchForUser(name);
        initializeGoogleResultsPage(driver);
        return areLinksToFacebook();
    }

    private Boolean areLinksToFacebook() {
        List<WebElement> links = googleResultsPage.getLinksOnPage();
        return links.stream().anyMatch(n -> n.getText().contains("www.facebook.com"));
    }

    private void searchForUser(String name){
        log.info(String.format("Searching for user \"%s\"...",name));

        googleSearchPage.setTextToGoogleSearchInput(name);
        googleSearchPage.googleSearchButtonClick();
    }

    private void initializeGoogleSearchPage(WebDriver driver) {
        log.info("Initialising Google search page...");

        googleSearchPage =new GoogleSearchPage(driver);
        googleSearchPage.openGoogleSearchPage();
        googleSearchPage.waitGooglePageLoad();
    }

    private void initializeGoogleResultsPage(WebDriver driver) {
        log.info("Initialising Google results page...");

        googleResultsPage=new GoogleResultsPage(driver);
        googleResultsPage.waitResultPageLoad();
    }
}
