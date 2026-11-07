package config;

import org.aeonbits.owner.Config;

public interface AuthConfig extends Config {

    @Key("user.name")
    String getUsername();

    @Key("user.accessKey")
    String getAccessKey();
}
