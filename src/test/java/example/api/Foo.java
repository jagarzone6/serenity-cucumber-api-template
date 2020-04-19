package example.api;

import example.support.api.BaseRequest;
import io.restassured.http.ContentType;
import net.thucydides.core.annotations.Shared;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;

public class Foo extends BaseRequest {

    @Shared
    Auth auth;

    public Foo() {
        super();
    }

    public void getFooInformation(String queryParams) {
        Map<String, Object> body = new HashMap<>();
        body.put("test","values");
        this.get(given().contentType(ContentType.JSON).body(body).cookie("sails.sid", auth.getSessionID()), "/get?" + queryParams);
    }

}
