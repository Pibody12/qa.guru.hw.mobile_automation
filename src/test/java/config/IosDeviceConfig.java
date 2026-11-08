package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:{device_iphone}.properties"
})

public interface IosDeviceConfig extends Config {

    @Key("platform.name")
    @DefaultValue("ios")
    String getPlatformName();

    @Key("device.name")
    @DefaultValue("iPhone 15 Pro")
    String getDeviceName();

    @Key("platform.version")
    @DefaultValue("17")
    String getPlatformVersion();
}