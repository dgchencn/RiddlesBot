package com.myteam.riddlesbot.pojo;

public class OpCode1Heart extends Payload{
    int op = 1;
    int d = 251;

    @Override
    public int getOp() {
        return op;
    }

    @Override
    public void setOp(int op) {
        this.op = op;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
