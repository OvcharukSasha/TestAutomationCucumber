package stepsRealization.api;

import helpers.ScenarioContext;
import helpers.FileWriterReader;
import helpers.RandomUserHelper;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static clients.restClients.RandomUserClient.sendGetMultipleUsersRequest;
import static clients.restClients.RandomUserClient.sendGetUser;
import static enums.Context.RESPONSE;

public class RandomUserAPISteps {
    private static Logger log = Logger.getLogger(RandomUserAPISteps.class.getName());
    private RandomUserHelper randomUserHelper = new RandomUserHelper();
    private FileWriterReader fileWriterReader = new FileWriterReader();
    ScenarioContext scenarioContext = new ScenarioContext();

    public void writeUsersNameIntoFile() {
        List<String> userNames = randomUserHelper.getMultipleUsersResultFromContext().stream()
                .map(x -> x.getName()).collect(Collectors.toList());
        try {
            fileWriterReader.writeDataIntoFile("Users", userNames);
        } catch (IOException e) {
            log.severe("Something went wrong while working with file...");
            throw new RuntimeException(e);
        }
    }

    public void sendGetMultipleRandomUsersRequest(int amount) {
        log.info(String.format("Sending request to get %s users", amount));
        scenarioContext.setContext(RESPONSE, sendGetMultipleUsersRequest(amount));
    }

    public int getStatusCodeFromResponse() {
        return randomUserHelper.getStatusCodeFromContextResponse();
    }

    public void sendGetRandomUserRequest() {
        log.info("Sending request to get one user");
        scenarioContext.setContext(RESPONSE, sendGetUser());
    }
}
