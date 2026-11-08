package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:Browserstack-IOS.properties"
})

public interface BrowserstackIosDriverConfig extends Config {

    @Key("automation.name")
    @DefaultValue("XCUITest")
    String getAutomationName();

    @Key("app.version")
    @DefaultValue("bs://sample.app")
    String getAppVersion();

    @Key("appium.version")
    @DefaultValue("2.12.1")
    String getAppiumVersion();

    @Key("project.name")
    @DefaultValue("First Java Project")
    String getProjectName();

    @Key("build.name")
    @DefaultValue("browserstack-build-1")
    String getBuildName();

    @Key("session.name")
    @DefaultValue("ios test")
    String getSessionName();

    @Key("browserstack.hub")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getBrowserstackHub();
}
