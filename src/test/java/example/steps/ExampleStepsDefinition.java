package example.steps;

import example.api.Auth;
import example.api.Foo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.then;

public class ExampleStepsDefinition {

    @Steps(shared = true)
    Auth auth;

    @Steps(shared = true)
    Foo foo;

    @Given("I am logged into the app")
    public void sign_in() {
        auth.loginWithBasicAuth("cG9zdG1hbjpwYXNzd29yZA==");
    }

    @When("I ask for foo information")
    public void i_ask_for_foo_information() {
        foo.getFooInformation("foo1=bar1&foo2=bar2");
    }

    @Then("I should receive valid foo information")
    public void i_should_receive_valid_foo_information() {
        then().assertThat().statusCode(200).and().body(matchesJsonSchemaInClasspath("json_schema/getFoo.json"));
    }
}
