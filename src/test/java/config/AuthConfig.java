package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("bs.username")
    String getUsername();

    @Key("bs.accessKey")
    String getAccessKey();
}
