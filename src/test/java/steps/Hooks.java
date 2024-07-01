package steps;

import support.DriverDefinition;
import support.SetupEnv;

import static java.lang.System.out;
import static utils.Screenshots.takingScreenshot;

import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverDefinition {
    public final long TIMEOUT = 5;
    public final String BASE_URL = SetupEnv.setBaseUrl();

    @Before
    public void init(Scenario scenario) {
        out.println("*************************************************\n"
                + "Running Test...\n"
                + "Scenario Name: [" + scenario.getName() + "]\n"
                + "Scenario Tags: " + scenario.getSourceTagNames() + "\n");

        DriverDefinition.setUp();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        getDriver().get(BASE_URL);
    }

    @After
    public void end(Scenario scenario) {
        out.println("Scenario Status: [" + scenario.getStatus() + "]\n" +
                "*************************************************");

        takingScreenshot(scenario);
        DriverDefinition.tearDown();
    }

}