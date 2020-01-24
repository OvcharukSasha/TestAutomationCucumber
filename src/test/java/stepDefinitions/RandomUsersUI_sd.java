package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepsRealization.ui.UICommonSteps;

import static org.hamcrest.MatcherAssert.assertThat;

public class RandomUsersUI_sd {
    private UICommonSteps uiCommonSteps;
    private WebDriver driver=new ChromeDriver();;

    @Before
    public void setUpBrowser() {
        if(null==driver) {
            driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver");
        }
        uiCommonSteps = new UICommonSteps(driver);
    }

    @After
    public void shutDownDriver() {
        if(null!=driver) {
            driver.close();
            driver.quit();
        }
    }

    @When("^I open Google Search Page$")
    public void iOpenGoogleSearchPage() {
        uiCommonSteps.openGoogleSearchPage();
    }

    @When("^I input users name in search field$")
    public void iInputUsersNameInSearchField() {
        uiCommonSteps.inputUserNameFromResponseInSearchField();
    }

    @When("^I click 'Search' button on Google Search page$")
    public void iClickSearchButtonOnGoogleSearchPage() {
        uiCommonSteps.clickGoogleSearchButton();
    }

    @Then("^I should see Google Results page loaded$")
    public void iShouldSeeGoogleResultsPageLoaded() {
        assertThat("Google Search page is not displayed.", uiCommonSteps.isGoogleResultPageLoaded());
    }

    @Then("^I verify there is a link to user account in Facebook$")
    public void iVerifyThereIsALinkToUserAccountInFacebook() {
        assertThat("There are any links to Facebook account for user.", uiCommonSteps.isLinkWithUserNamePresent());
    }

    @And("^I input random name from \\.xlsx file in search field$")
    public void iInputRandomNameFromXlsxFileInSearchField() {
        uiCommonSteps.inputRandomUserNameFromFileInSearchField();
    }
}
