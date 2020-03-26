package example.api;

import example.support.api.BaseRequest;
import net.thucydides.core.annotations.Shared;

import static net.serenitybdd.rest.SerenityRest.given;

public class Foo extends BaseRequest {

    @Shared
    Auth auth;

    public Foo() {
        super();
    }

    public void getFooInformation(String queryParams) {
        this.get(given().cookie("sails.sid", auth.getSessionID()), "/get?" + queryParams);
    }

}
