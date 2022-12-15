package com.coe.GroupChatMessage.model;

import com.coe.GroupChatMessageProducer.entity.GroupChatMessageEntity;

import java.io.Serializable;
import java.util.Date;

public class GroupChatMessage implements Serializable {
    private int id;
    private int groupChatAdminId;
    private GroupChatMessageEntity GroupChatMessageId;
    private String content;
    private Date createDate;
    private String status;

    public GroupChatMessage() {
    }

    public GroupChatMessage(GroupChatMessageEntity entity) {
        this.id = entity.getId();
        this.GroupChatMessageId = entity.getGroupChatMessageId();
        this.groupChatAdminId = entity.getGroupChatAdminId();
        this.content = entity.getContent();
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
        return GroupChatMessageId;
    }

    public void setGroupChatMessageId(GroupChatMessageEntity groupChatMessageId) {
        GroupChatMessageId = groupChatMessageId;
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
                ", GroupChatMessageId=" + GroupChatMessageId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }
}
