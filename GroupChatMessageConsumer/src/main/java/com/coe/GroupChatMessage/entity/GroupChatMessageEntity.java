package com.coe.GroupChatMessage.entity;

import com.coe.kafkaproducer.model.GroupChatMessage;

import javax.persistence.*;
import java.util.Date;

enum Status {Sent, Received, Seen, Error}

@Entity
@Table(name = "group_chat_message")
public class GroupChatMessageEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_chat_admin_id", referencedColumnName = "id", nullable = false)
    private GroupChatAdmin groupChatAdminId;

    @OneToOne
    @JoinColumn(name = "chat_message_fk", referencedColumnName = "id", nullable = false)
    private GroupChatMessageEntity ChatMessageFk;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "status", columnDefinition = "ENUM('Sent, Received, Seen, Error')")
    @Enumerated(EnumType.STRING)
    private Status status;


    //Constructor Kafka Controller
    public GroupChatMessageEntity(GroupChatMessage groupChatMessage) {
        this.id = groupChatMessage.getId();
        this.groupChatAdminId = new GroupChatAdmin(1,new Customer(),new GroupChat());
        this.ChatMessageFk = this; //Buscar como declarar
        this.content = groupChatMessage.getContent();
        this.createDate = groupChatMessage.getCreateDate();
        this.status = Status.Sent; //Buscar como declarar
    }

    public GroupChatMessageEntity() {

    }

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
