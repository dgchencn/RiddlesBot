package com.myteam.riddlesbot.util;

import com.alibaba.fastjson.JSONObject;
import com.myteam.riddlesbot.config.ValueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpUtil {

    @Autowired
    private RestTemplate restTemplate;

    //发送post请求消息，以json作为内容参数
    public void postMessage(String channel_id, String content, String msg_id){
        //请求地址
        String url = ValueConfig.url + "/channels/"+channel_id+"/messages";

        //头信息设置，包括Authorization认证信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", ValueConfig.authorizations);
        //提交参数设置
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", content);
        jsonObject.put("msg_id", msg_id);
        //将请求头部和参数合成一个请求
        HttpEntity request = new HttpEntity(jsonObject.toJSONString(),headers);

        //发起post请求
        String s = restTemplate.postForObject(url, request, String.class);
    }

    //获取websocket地址url
    public String getGateway(){
        //请求地址
        String url = ValueConfig.url + "/gateway";
        //头信息设置，包括Authorization认证信息
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", ValueConfig.authorizations);
        //发起get请求
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                String.class
        );
        JSONObject jsonObject = JSONObject.parseObject(response.getBody());
        return jsonObject.get("url").toString();
    }
}
