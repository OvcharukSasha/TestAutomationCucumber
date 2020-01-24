package clients.restClients;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RandomUserClient {
    private static final String GET_USER_REQUEST = "https://randomuser.me/api/";
    private static final String NUMBER_PARAMETER = "results";

    public static Response sendGetMultipleUsersRequest(int usersAmount) {
        return given().queryParam(NUMBER_PARAMETER, usersAmount).get(GET_USER_REQUEST);
    }

    public static Response sendGetUser() {
        return given().get(GET_USER_REQUEST);
    }
}
