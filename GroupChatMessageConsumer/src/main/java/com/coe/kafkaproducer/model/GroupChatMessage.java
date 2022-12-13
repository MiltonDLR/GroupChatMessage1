package com.coe.kafkaproducer.model;

import com.coe.GroupChatMessage.entity.GroupChatMessageEntity;
import com.coe.GroupChatMessageProducer.model.GroupChatAdmin;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

enum Status {Sent, Received, Seen, Error}

public class GroupChatMessage implements Serializable {
    private int id;
    private GroupChatAdmin groupChatAdminId;
    private GroupChatMessageEntity ChatMessageFk;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    private Status status;

    public GroupChatMessage(GroupChatMessageEntity entity) {
        this.id = entity.getId();
//        this.groupChatAdminId = entity.getGroupChatAdminId();
        this.ChatMessageFk = entity.getChatMessageFk();
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
//        this.status = entity.getStatus();
    }

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

    public GroupChatMessageEntity getChatMessageFk() {
        return ChatMessageFk;
    }

    public void setChatMessageFk(GroupChatMessageEntity chatMessageFk) {
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
