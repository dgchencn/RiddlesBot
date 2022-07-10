package com.myteam.riddlesbot.pojo.d;

public class Resume {
    /*
    "token": "my_token",
    "session_id": "session_id_i_stored",
    "seq": 1337
     */
    String token = "my_token";
    String session_id = "session_id_i_stored";
    int seq = 1337;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
