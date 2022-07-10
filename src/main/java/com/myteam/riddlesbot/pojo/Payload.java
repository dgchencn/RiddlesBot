package com.myteam.riddlesbot.pojo;

//在 websocket 连接上传输的数据，网关的上下行消息采用的都是同一个结构
public class Payload {
    /*
op 指的是 opcode，全部 opcode 列表参考 opcode。

s 下行消息都会有一个序列号，标识消息的唯一性，客户端需要再发送心跳的时候，携带客户端收到的最新的s。

t和d 主要是用在op为 0 Dispatch 的时候，t 代表事件类型，d 代表事件内容，不同事件类型的事件内容格式都不同，请注意识别。
     */
    int op;
    int s;
    String t;

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}
