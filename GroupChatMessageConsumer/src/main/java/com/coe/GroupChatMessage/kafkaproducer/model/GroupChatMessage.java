package com.coe.GroupChatMessage.kafkaproducer.model;

import com.coe.GroupChatMessage.entity.GroupChatMessageEntity;


import java.io.Serializable;
import java.util.Date;

public class GroupChatMessage implements Serializable {
    private int id;
    private int groupChatAdminId;
    private GroupChatMessageEntity groupChatMessageId;
    private String content;
    private Date createDate;
    private String status;

    public GroupChatMessage() {
    }

    public GroupChatMessage(GroupChatMessageEntity entity){
        this.id = entity.getId();
        this.groupChatMessageId = entity.getGroupChatMessageId();
        this.groupChatAdminId = entity.getGroupChatAdminId();
        this.content =entity.getContent();
        this.createDate = entity.getCreateDate();
        this.status = entity.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupChatAdminId() {
        return groupChatAdminId;
    }

    public void setGroupChatAdminId(int groupChatAdminId) {
        this.groupChatAdminId = groupChatAdminId;
    }

    public GroupChatMessageEntity getGroupChatMessageId() {
        return groupChatMessageId;
    }

    public void setGroupChatMessageId(GroupChatMessageEntity groupChatMessageId) {
        this.groupChatMessageId = groupChatMessageId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GroupChatMessage{" +
                "id=" + id +
                ", groupChatAdminId=" + groupChatAdminId +
                ", groupChatMessageId=" + groupChatMessageId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }
}
