package com.myteam.riddlesbot.pojo.d;


import com.myteam.riddlesbot.bean.User;

public class ReadyEvent {
    /*
    "version": 1,
    "session_id": "082ee18c-0be3-491b-9d8b-fbd95c51673a",
    "user": {
      "id": "6158788878435714165",
      "username": "群pro测试机器人",
      "bot": true
    },
    "shard": [0, 0]
     */
    String version;
    String session_id;
    User user;
    int[] shard;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int[] getShard() {
        return shard;
    }

    public void setShard(int[] shard) {
        this.shard = shard;
    }
}
