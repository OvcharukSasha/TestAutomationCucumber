package clients.restClients;

import DTOs.DTORandomUser;
import com.google.gson.Gson;
import io.restassured.response.Response;

import java.util.List;

import static helpers.RandomUserAPIHelper.sendGetMultipleUsersWithParams;
import static helpers.RandomUserAPIHelper.sendGetUser;

public class RandomUserClient {

    public List<DTORandomUser.Result> getMultipleUsers(int usersAmount) {
        Response response = sendGetMultipleUsersWithParams(usersAmount);
        return getDTORandomUserFromResponse(response).getResults();
    }

    public DTORandomUser getDTORandomUserFromResponse(Response response){
        return new Gson().fromJson(response.asString(), DTORandomUser.class);
    }

    public DTORandomUser.Result getUser() {
        Response response = sendGetUser();
        return getDTORandomUserFromResponse(response).getResults().get(0);
    }
}
