package helpers;

import DTOs.DTORandomUser;
import com.google.gson.Gson;
import io.restassured.response.Response;
import java.util.List;
import static enums.Context.RESPONSE;
import static helpers.ScenarioContext.getContext;

public class RandomUserHelper {

    public DTORandomUser getDTORandomUserFromResponse(Response response) {
        return new Gson().fromJson(response.asString(), DTORandomUser.class);
    }

    public DTORandomUser.Result getUser(Response response) {
        return getDTORandomUserFromResponse(response).getResults().get(0);
    }

    public List<DTORandomUser.Result> getMultipleUsersResultFromContext() {
        if (hasContextResponseType())
            return getDTORandomUserFromResponse(getContextResponse()).getResults();
        throw new IllegalArgumentException("Scenario context for 'RESPONSE' key has wrong type.");
    }

    public String getUserNameFromContextRespose() {
        if (hasContextResponseType())
            return getUser(getContextResponse()).getName();
        throw new IllegalArgumentException("Scenario context for 'RESPONSE' key has wrong type.");
    }

    public int getStatusCodeFromContextResponse() {
        if (hasContextResponseType()) {
            return getContextResponse().getStatusCode();
        }
        throw new IllegalArgumentException("Scenario context for 'RESPONSE' key has wrong type.");
    }

    private boolean hasContextResponseType() {
        return getContext(RESPONSE) instanceof Response;
    }

    private Response getContextResponse() {
        return (Response) ScenarioContext.getContext(RESPONSE);
    }
}
