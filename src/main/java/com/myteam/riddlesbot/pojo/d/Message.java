package com.myteam.riddlesbot.pojo.d;


import com.myteam.riddlesbot.bean.Member;
import com.myteam.riddlesbot.bean.User;

public class Message {
    String id;
    String channel_id;
    String guild_id;
    String content;
    String timestamp;
    String edited_timestamp;
    boolean mention_everyone;
    User author;
    User[] mentions;
    Member member;
    int seq;
    String seq_in_channel;
    String src_guild_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getGuild_id() {
        return guild_id;
    }

    public void setGuild_id(String guild_id) {
        this.guild_id = guild_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEdited_timestamp() {
        return edited_timestamp;
    }

    public void setEdited_timestamp(String edited_timestamp) {
        this.edited_timestamp = edited_timestamp;
    }

    public boolean isMention_everyone() {
        return mention_everyone;
    }

    public void setMention_everyone(boolean mention_everyone) {
        this.mention_everyone = mention_everyone;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User[] getMentions() {
        return mentions;
    }

    public void setMentions(User[] mentions) {
        this.mentions = mentions;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getSeq_in_channel() {
        return seq_in_channel;
    }

    public void setSeq_in_channel(String seq_in_channel) {
        this.seq_in_channel = seq_in_channel;
    }

    public String getSrc_guild_id() {
        return src_guild_id;
    }

    public void setSrc_guild_id(String src_guild_id) {
        this.src_guild_id = src_guild_id;
    }
}
