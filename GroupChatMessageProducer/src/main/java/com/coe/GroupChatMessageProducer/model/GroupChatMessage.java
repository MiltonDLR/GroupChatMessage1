package com.coe.GroupChatMessageProducer.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

enum Status {
    Sent,
    Received,
    Seen,
    Error
}
public class GroupChatMessage implements Serializable {

    private int id;
    private GroupChatAdmin groupChatAdminId;
    private GroupChatMessage ChatMessageFk;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    private Status status;

    //Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public GroupChatAdmin getGroupChatAdminId() {
        return groupChatAdminId;
    }
    public void setGroupChatAdminId(GroupChatAdmin groupChatAdminId) {
        this.groupChatAdminId = groupChatAdminId;
    }

    public GroupChatMessage getChatMessageFk() {
        return ChatMessageFk;
    }
    public void setChatMessageFk(GroupChatMessage chatMessageFk) {
        ChatMessageFk = chatMessageFk;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
