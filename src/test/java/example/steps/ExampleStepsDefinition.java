package example.steps;

import example.support.api.BaseRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class ExampleStepsDefinition extends BaseRequest {

    @Given("I am logged into the app")
    public void sign_in() {
        this.get(given().header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA=="), "/basic-auth");
    }

    @When("I ask for foo information")
    public void i_ask_for_foo_information() {
        this.get(given(), "/get?foo1=bar1&foo2=bar2");
    }

    @Then("I should receive valid foo information")
    public void i_should_receive_valid_foo_information() {
        then().assertThat().statusCode(200).and().body(matchesJsonSchemaInClasspath("json_schema/getFoo.json"));
    }
}
