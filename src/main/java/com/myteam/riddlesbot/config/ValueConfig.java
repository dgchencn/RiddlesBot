package com.myteam.riddlesbot.config;

public class ValueConfig {
    public static String url = "https://sandbox.api.sgroup.qq.com";
    public static String authorizations = "Bot {appID}.{appToken}";
    public static int intents = 0|1<<30;//代表订阅的事件类型，这里指订阅用户发消息事件
}
