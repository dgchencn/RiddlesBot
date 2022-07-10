package com.myteam.riddlesbot.pojo;


import com.myteam.riddlesbot.pojo.d.Identify;

public class OpCode2Identify extends Payload{
    int op = 2;
    Identify d = new Identify();

    @Override
    public int getOp() {
        return op;
    }

    @Override
    public void setOp(int op) {
        this.op = op;
    }

    public Identify getD() {
        return d;
    }

    public void setD(Identify d) {
        this.d = d;
    }
}
