package steps;

import support.SetURL;
import support.DriverDefinition;

import static java.lang.System.out;
import static utils.Screenshots.takingScreenshot;

import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverDefinition {
    String baseUrl = SetURL.urlBase();

    @Before
    public void init(Scenario scenario) {
        out.println("*************************************************");
        out.println("Starting Test Execution...");
        out.println("Running Scenario: [" + scenario.getName() + "]");
        out.println("Scenario Status: [" + scenario.getStatus() + "]");
        out.println("Execution Tag: " + scenario.getSourceTagNames());
        out.println("*************************************************");
        setDriver();

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().get(baseUrl);
    }

    @AfterStep
    public static void addReport(Scenario scenario) {
        takingScreenshot(scenario);
    }

    @After
    public void end() {
        out.println("***************************");
        out.println("Finishing Test Execution...");
        out.println("***************************");
        out.println(" ");
        getDriver().quit();
    }

}