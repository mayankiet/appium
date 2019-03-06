package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.io.IOException;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.SESSION_OVERRIDE;

public class StartAppiumServer {

    private AppiumDriverLocalService appiumDriverLocalService;

    @Before
    public void startAppium() throws IOException{

        int port = 4723;
        String nodeJS_Path = "C://Program Files//NodeJS/node.exe";
        String appiumJS_Path = "C://Program Files/Appium//node_modules//appium//bin//appium.js";
        String osName = System.getProperty("os.name");
        if (osName.contains("Mac")) {
            appiumDriverLocalService = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                            .withAppiumJS(new File("/usr/local/bin/appium"))
                            .usingDriverExecutable(new File("/usr/local/bin/node"))
                            .withIPAddress("127.0.0.1")
                            .usingPort(port)
                            .withArgument(SESSION_OVERRIDE));
        } else if (osName.contains("Windows")) {
            appiumDriverLocalService = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                            .usingDriverExecutable(new File(nodeJS_Path))
                            .withAppiumJS(new File(appiumJS_Path))
                            .withIPAddress("0.0.0.0")
                            .usingPort(port)
                            .withArgument(SESSION_OVERRIDE)
                            .withLogFile(new File("build/appium.log")));
        }
        appiumDriverLocalService.start();
    }

    @After
    public void StopAppiumServer() {

        appiumDriverLocalService.stop();
    }
}
