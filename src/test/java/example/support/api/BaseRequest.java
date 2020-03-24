package example.support.api;

import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class BaseRequest {

    private static String url;
    private static EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    public BaseRequest() {
        url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("api.base.url");
    }

    public ResponseOptions get(RequestSpecification requestSpecification, String s) {
        return requestSpecification.baseUri(url).when().get(s);
    }

    public ResponseOptions post(RequestSpecification requestSpecification, String s) {
        return requestSpecification.baseUri(url).when().post(s);
    }

    public ResponseOptions put(RequestSpecification requestSpecification, String s) {
        return requestSpecification.baseUri(url).when().put(s);
    }

    public ResponseOptions delete(RequestSpecification requestSpecification, String s) {
        return requestSpecification.baseUri(url).when().delete(s);
    }

    public ResponseOptions options(RequestSpecification requestSpecification, String s) {
        return requestSpecification.baseUri(url).when().options(s);
    }

}
