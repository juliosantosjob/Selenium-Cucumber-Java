package steps;

import support.BasePage;

import static java.lang.System.out;
import static utils.Screenshots.takingScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import support.ViewManager;

public class Hooks extends BasePage {
    public final long TIMEOUT = 5;

    @Before
    public void init(Scenario scenario) {
        out.println("*************************************************\n"
                + "Running Test...\n"
                + "Scenario Name: [" + scenario.getName() + "]\n"
                + "Scenario Tags: " + scenario.getSourceTagNames() + "\n"
                + "*************************************************");

        BasePage.setUp();
        ViewManager.setViewPort();
    }

    @After
    public void end(Scenario scenario) {
        out.println("Scenario Status: [" + scenario.getStatus() + "]\n");
        takingScreenshot(scenario);
        BasePage.tearDown();
    }

}