package com.myteam.riddlesbot.pojo.d;


import com.myteam.riddlesbot.config.ValueConfig;

public class Identify {
    /*
    "token": "my_token",
    "intents": 513,
    "shard": [0, 4],
    "properties": {
      "$os": "linux",
      "$browser": "my_library",
      "$device": "my_library"
    }
     */
    String token = ValueConfig.authorizations;
    int intents = ValueConfig.intents;
    int[] shard = {0, 1};
    Object properties = new Properties();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIntents() {
        return intents;
    }

    public void setIntents(int intents) {
        this.intents = intents;
    }

    public int[] getShard() {
        return shard;
    }

    public void setShard(int[] shard) {
        this.shard = shard;
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }
}

class Properties {
    String $os = "linux";
    String $browser = "my_library";
    String $device = "my_library";

    public String get$os() {
        return $os;
    }

    public void set$os(String $os) {
        this.$os = $os;
    }

    public String get$browser() {
        return $browser;
    }

    public void set$browser(String $browser) {
        this.$browser = $browser;
    }

    public String get$device() {
        return $device;
    }

    public void set$device(String $device) {
        this.$device = $device;
    }
}