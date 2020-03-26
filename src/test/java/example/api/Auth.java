package example.api;

import example.support.api.BaseRequest;

import static net.serenitybdd.rest.SerenityRest.given;

public class Auth extends BaseRequest {

    private static final String BASIC_AUTH_PATH = "/basic-auth";
    private String sessionID;

    public Auth() {
        super();
    }

    public void loginWithBasicAuth(String encodedUserPass) {
        this.sessionID =
                this.get(given().header("Authorization", "Basic " + encodedUserPass), BASIC_AUTH_PATH).getCookie(
                        "sails.sid");
    }

    public String getSessionID() {
        return this.sessionID;
    }


}
