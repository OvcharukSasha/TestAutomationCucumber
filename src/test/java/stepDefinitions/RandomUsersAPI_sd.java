package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepsRealization.api.RandomUserAPISteps;

import static org.hamcrest.MatcherAssert.assertThat;

public class RandomUsersAPI_sd {
    RandomUserAPISteps randomUserAPISteps = new RandomUserAPISteps();


    @Given("^I send request to get (\\d+) people$")
    public void iSendRequestToGetNumberOfPeople(int amount) {
        randomUserAPISteps.sendGetMultipleRandomUsersRequest(amount);
    }

    @Then("^I verify response status code is (\\d+)$")
    public void iVerifyResponseStatusCodeIs(int status) {
        int actualStatus = randomUserAPISteps.getStatusCodeFromResponse();
        assertThat(String.format("Status code is not as expected. Expected: %s , Actual: %s", status, actualStatus), actualStatus == status);
    }

    @Given("^I send request to get one random person name$")
    public void iSendRequestToGetOneRandomPersonName() {
        randomUserAPISteps.sendGetRandomUserRequest();

    }

    @When("^I write down users data into \\.xlsx file$")
    public void iWriteDownUsersDataIntoXlsxFile() {
        randomUserAPISteps.writeUsersNameIntoFile();
    }
}
