package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackIosDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("platformName", "ios");
        caps.setCapability("appium:deviceName", "iPhone 14 Pro");
        caps.setCapability("appium:platformVersion", "16");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:app", "bs://sample.app");

        HashMap<String, Object> bstackOptions = new HashMap<>();

        bstackOptions.put("userName", "drobotenkotimofe_aFRH7J");
        bstackOptions.put("accessKey", "XQqGSSo1oR5sYnBJJGnf");
        bstackOptions.put("appiumVersion", "2.12.1");
        bstackOptions.put("projectName", "First iOS Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_test");

        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new IOSDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}