package utils;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.BasePage;

import java.io.File;
import java.io.IOException;

public class Screenshots extends BasePage {

    public static void shot(Scenario scenario) {
        try {
            File screenshotAs = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Erro ao implementar captura de tela!");
        }
    }

    public static void takingScreenshot(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                System.out.println("Cenário falhou: " + scenario.getName());
            }
            stop(1);
            shot(scenario);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao capturar screenshot", e);
        }
    }
}
