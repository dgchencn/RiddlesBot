package com.myteam.riddlesbot.pojo;


import com.myteam.riddlesbot.pojo.d.Message;

public class OpCode0Message extends Payload {
    String id;
    Message d;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Message getD() {
        return d;
    }

    public void setD(Message d) {
        this.d = d;
    }
}
