package steps;

import support.BasePage;

import static java.lang.System.out;
import static utils.Screenshots.takingScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import support.ViewManager;

import java.nio.file.Paths;

public class Hooks extends BasePage {

    @Before
    public void init(Scenario scenario) {
        BasePage.setUp();
        ViewManager.setViewPort();

        out.println("*************************************************\n"
                + "Running Test...\n"
                + "Scenario Name: " + scenario.getName() + "\n"
                + "Scenario Feature: " + Paths.get(scenario.getUri()).getFileName().toString() + "\n"
                + "Scenario Tags: " + scenario.getSourceTagNames());
    }

    @After
    public void end(Scenario scenario) {
        out.println("Scenario Status: " + scenario.getStatus()
                + "\n*************************************************");
        takingScreenshot(scenario);
        BasePage.tearDown();
    }
}