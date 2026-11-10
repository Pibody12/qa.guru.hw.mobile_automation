package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${device_android}.properties"
})

public interface AndroidDeviceConfig extends Config{

    @Key("platform.name")
    @DefaultValue("android")
    String getPlatformName();

    @Key("device.name")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDeviceName();

    @Key("platform.version")
    @DefaultValue("12.0")
    String getPlatformVersion();
}
