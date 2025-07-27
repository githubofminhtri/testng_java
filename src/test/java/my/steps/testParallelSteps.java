package my.steps;

import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class testParallelSteps {
    private final Logger logger = LoggerFactory.getLogger(testParallelSteps.class);
    @Given("Run scenario {string}")
    public void runScenario(String arg0) {
        this.logger.info("Scenario {} - Thread {}",arg0,Thread.currentThread().getId());
    }
}
