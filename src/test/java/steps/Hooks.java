package steps;


import support.DriverDefinition;

import static java.lang.System.out;
import static support.BeforwardRunning.addSettings;
import static utils.Screenshots.takingScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverDefinition {

    @Before
    public void init(Scenario scenario) {
        out.println("*************************************************");
        out.println("Starting Test Execution...");
        out.println("Running Scenario: [" +  scenario.getName() + "]");
        out.println("Scenario Status: [" +  scenario.getStatus() +  "]");
        out.println("Execution Tag: " +  scenario.getSourceTagNames());
        out.println("*************************************************");
        browserConfig();
        addSettings();
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
        driver.quit();
    }
    
}