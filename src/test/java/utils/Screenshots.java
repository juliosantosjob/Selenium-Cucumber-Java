package utils;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.BasePage;

import java.io.File;

import static java.lang.System.out;

public class Screenshots extends BasePage {

    /**
     * Screenshots settings in the project using adaptation of the allure report.
     *
     * @param scenario
     */

    public static void shot(Scenario scenario) {
        try {
            File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
        } catch (Exception e) {
            out.println("Error implementing screenshot!");
        }
    }

    /**
     * Conditional for success or failure screenshots.
     * in this method the screenshots will be executed at the end of each step, the
     * necessary parameter for the execution would be the scenario itself to be
     * executed.
     *
     * @param scenario
     */

    public static void takingScreenshot(Scenario scenario) {
        if (!scenario.isFailed()) {
            sleep(1000);
            shot(scenario);
        } else {
            out.println("****** Scenario Name: [" + scenario.getName() + "]");
            out.println("****** Scenario Status: [" + scenario.getStatus() + "]");
            shot(scenario);
        }
    }
}