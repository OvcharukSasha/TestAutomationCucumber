package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {

    private WebDriver driver;
    private static final String GOOGLE_SEARCH_PAGE_URL = "https://www.google.com";
    private static WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"hplogo\"]")
    private WebElement logoImg;

    @FindBy(xpath = "//input[@class=\"gLFyf gsfi\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//div[3]/center/input[@name='btnK']")
    private WebElement googleSearchButton;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public void openGoogleSearchPage() {
        driver.manage().window().maximize();
        driver.get(GOOGLE_SEARCH_PAGE_URL);
    }

    public void googleSearchButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(googleSearchButton));
        this.googleSearchButton.click();
    }

    public void inputTextInSearchField(String text) {
        searchInput.sendKeys(text);
        logoImg.click();
    }

    public void waitGooglePageLoad() {
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(searchInput),
                        ExpectedConditions.visibilityOf(logoImg))
        );
    }
}
