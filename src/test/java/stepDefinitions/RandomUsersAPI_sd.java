package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import stepsRealization.api.RandomUserSteps;
import utils.ScenarioContext;

public class RandomUsersAPI_sd {
RandomUserSteps randomUserSteps = new RandomUserSteps();
ScenarioContext scenarioContext=new ScenarioContext();

    @Given("^I send request to get (\\d+) people$")
    public void iSendRequestToGetNumberOfPeople(int amount) {
        randomUserSteps.getSetOfUsers(amount);
        System.out.println(String.format("Amount of women: %d;", randomUserSteps.getGenderAmountFromUsersList("female")));
        System.out.println(String.format("Amount of men: %d;", randomUserSteps.getGenderAmountFromUsersList("male")));

    }

    @Then("^I verify response status code is (\\d+)$")
    public void iVerifyResponseStatusCodeIs(int status) {

    }
}
