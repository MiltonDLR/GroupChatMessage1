package com.coe.GroupChatMessage.entity;

import com.coe.kafkaproducer.model.GroupChatMessage;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "group_chat_message")
public class GroupChatMessageEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_chat_admin_id")//, referencedColumnName = "id")
    private int groupChatAdminId;

    @OneToOne
    @JoinColumn(name = "chat_message_fk", referencedColumnName = "id")
    private GroupChatMessageEntity groupChatMessageId;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private String status;

    public GroupChatMessageEntity() {
    }

    //Constructor Kafka Controller
    public GroupChatMessageEntity(GroupChatMessage groupChatMessage) {
        this.id = groupChatMessage.getId();
        this.groupChatAdminId = groupChatMessage.getGroupChatAdminId();
        this.groupChatMessageId = groupChatMessage.getGroupChatMessageId();
        this.content = groupChatMessage.getContent();
        this.createDate = groupChatMessage.getCreateDate();
        this.status = groupChatMessage.getStatus();
    }

    //Getters & Setters

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
        return "GroupChatMessageEntity{" +
                "id=" + id +
                ", groupChatAdminId=" + groupChatAdminId +
                ", groupChatMessageId=" + groupChatMessageId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }

    public void updateEntity(GroupChatMessage groupChatMessage){
        this.content = groupChatMessage.getContent();
    }
}
