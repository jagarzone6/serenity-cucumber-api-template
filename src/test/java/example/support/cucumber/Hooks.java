package example.support.cucumber;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void doSomethingBeforeScenario(Scenario scenario) {
        System.out.println("doSomethingBeforeScenario");
    }

    @After
    public void doSomethingAfterScenario(Scenario scenario) {
        System.out.println("doSomethingAfterScenario");
    }
}
