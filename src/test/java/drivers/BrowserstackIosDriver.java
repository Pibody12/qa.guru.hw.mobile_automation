package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserstackIosDriverConfig;
import config.IosDeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackIosDriver implements WebDriverProvider {

    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    BrowserstackIosDriverConfig browserstackConfig = ConfigFactory.create(BrowserstackIosDriverConfig.class, System.getProperties());
    IosDeviceConfig deviceConfig = ConfigFactory.create(IosDeviceConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("platformName", deviceConfig.getPlatformName());
        caps.setCapability("appium:deviceName", deviceConfig.getDeviceName());
        caps.setCapability("appium:platformVersion", deviceConfig.getPlatformVersion());
        caps.setCapability("appium:automationName", browserstackConfig.getAutomationName());
        caps.setCapability("appium:app", browserstackConfig.getAppVersion());

        HashMap<String, Object> bstackOptions = new HashMap<>();

        bstackOptions.put("userName", authConfig.getUsername());
        bstackOptions.put("accessKey", authConfig.getAccessKey());
        bstackOptions.put("appiumVersion", browserstackConfig.getAppiumVersion());
        bstackOptions.put("projectName", browserstackConfig.getProjectName());
        bstackOptions.put("buildName", browserstackConfig.getBuildName());
        bstackOptions.put("sessionName", browserstackConfig.getSessionName());

        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new IOSDriver(
                    new URL(browserstackConfig.getBrowserstackHub()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}