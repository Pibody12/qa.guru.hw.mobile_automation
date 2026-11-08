package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AndroidDeviceConfig;
import config.AuthConfig;
import config.BrowserstackAndroidDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackAndroidDriver implements WebDriverProvider {

    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    BrowserstackAndroidDriverConfig browserstackConfig = ConfigFactory.create(BrowserstackAndroidDriverConfig.class, System.getProperties());
    AndroidDeviceConfig androidConfig = ConfigFactory.create(AndroidDeviceConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("platformName", androidConfig.getPlatformName());
        caps.setCapability("appium:deviceName", androidConfig.getDeviceName());
        caps.setCapability("appium:platformVersion", androidConfig.getPlatformVersion());
        caps.setCapability("appium:automationName", browserstackConfig.getAutomationName());
        caps.setCapability("appium:app", browserstackConfig.getAppVersion());
//        Для новой версии вики
//        caps.setCapability("appium:app", "bs://206d07292e9b4056d5d41f099ebbc79aa9360185");

        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", authConfig.getUsername());
        bstackOptions.put("accessKey", authConfig.getAccessKey());
        bstackOptions.put("appiumVersion", browserstackConfig.getAppiumVersion());
        bstackOptions.put("projectName", browserstackConfig.getProjectName());
        bstackOptions.put("buildName", browserstackConfig.getBuildName());
        bstackOptions.put("sessionName", browserstackConfig.getSessionName());
        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new AndroidDriver(
                    new URL(browserstackConfig.getBrowserstackHub()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}