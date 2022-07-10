package com.myteam.riddlesbot.bean;

public class Member {
    User user;
    String nick;
    String[] roles;
    String joined_at;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(String joined_at) {
        this.joined_at = joined_at;
    }
}
