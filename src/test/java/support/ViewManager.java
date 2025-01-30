package support;

import org.openqa.selenium.Dimension;

import java.time.Duration;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class ViewManager extends BasePage {
    private static final String viewPort = System.getProperty("SET_VIEWPORT");

    public static void setViewPort() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        if (viewPort == null || viewPort.isEmpty()) {
            getDriver().manage().window().maximize();
        } else {
            String[] size = viewPort.toLowerCase().split("x");
            if (size.length != 2) {
                throw new IllegalArgumentException("Invalid viewport size: " + viewPort + "Expected format: widthxheight (e.g., 1920x1080).");
            }
            getDriver().manage().window().setSize(new Dimension(parseInt(size[0]), parseInt(size[1])));
        }
    }
}