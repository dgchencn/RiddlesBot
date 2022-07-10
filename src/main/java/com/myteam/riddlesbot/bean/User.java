package com.myteam.riddlesbot.bean;
/*
用户类
id	string	用户 id
username	string	用户名
avatar	string	用户头像地址
bot	bool	是否是机器人
union_openid	string	特殊关联应用的 openid，需要特殊申请并配置后才会返回。如需申请，请联系平台运营人员。
union_user_account	string	机器人关联的互联应用的用户信息，与union_openid关联的应用是同一个。如需申请，请联系平台运营人员。
 */
public class User {
    String id;
    String username;
    String avatar;
    String union_openid;
    String union_user_account;
    boolean bot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUnion_openid() {
        return union_openid;
    }

    public void setUnion_openid(String union_openid) {
        this.union_openid = union_openid;
    }

    public String getUnion_user_account() {
        return union_user_account;
    }

    public void setUnion_user_account(String union_user_account) {
        this.union_user_account = union_user_account;
    }
}
