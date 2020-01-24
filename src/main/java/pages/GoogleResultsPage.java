package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleResultsPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(xpath = "//cite")
    private List<WebElement> links;

    @FindBy(xpath = "//*[@id=\"resultStats\"]")
    private WebElement resultStatus;

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 120);
        PageFactory.initElements(this.driver, this);

    }

    public void waitResultPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(resultStatus));
    }

    public List<WebElement> getLinksOnPage() {
        return links;
    }

    public boolean isPageDisplayed() {
        waitResultPageLoad();
        return resultStatus.isDisplayed();
    }
}
