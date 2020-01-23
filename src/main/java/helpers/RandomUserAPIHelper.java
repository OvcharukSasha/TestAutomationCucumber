package helpers;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RandomUserAPIHelper {

    private static final String GET_USER_REQUEST = "https://randomuser.me/api/";
    private static final String NUMBER_PARAMETER = "results";

    public static Response sendGetMultipleUsersWithParams(int usersAmount) {
        return given().queryParam(NUMBER_PARAMETER, usersAmount).get(GET_USER_REQUEST);
    }

    public static Response sendGetUser() {
        return given().get(GET_USER_REQUEST);
    }
}
