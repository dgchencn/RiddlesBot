package com.myteam.riddlesbot.pojo;


import com.myteam.riddlesbot.pojo.d.Hello;

public class OpCode10Hello extends Payload{
    Hello d = new Hello();

    public Hello getD() {
        return d;
    }

    public void setD(Hello d) {
        this.d = d;
    }
}
