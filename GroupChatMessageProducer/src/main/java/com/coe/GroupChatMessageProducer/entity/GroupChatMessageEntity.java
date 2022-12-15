package com.coe.GroupChatMessageProducer.entity;

import com.coe.GroupChatMessageProducer.model.GroupChatMessage;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="group_chat_message")
public class GroupChatMessageEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //Parte de manuel cuidado.
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="group_chat_admin_id", referencedColumnName = "id", nullable = false)
    @Column(name="group_chat_admin_id")
    private int groupChatAdminId;

    @OneToOne
    @JoinColumn(name = "chat_message_fk", referencedColumnName = "id")
    private GroupChatMessageEntity GroupChatMessageId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "status")
    private String status;


    public GroupChatMessageEntity() {
    }
    public GroupChatMessageEntity(GroupChatMessage groupChatMessage) {
        //this.id = groupChatMessage.getId();
        //this.groupChatAdminId = groupChatMessage.getAdmin
        //this.ChatMessageFk = this; //Buscar como declarar
        //this.content = groupChatMessage.getContent();
        //this.createDate = groupChatMessage.getCreateDate();
        //this.status = S.Sent; //Buscar como declarar
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
        return "GroupChatMessageEntity{" +
                "id=" + id +
                ", groupChatAdminId=" + groupChatAdminId +
                ", GroupChatMessageId=" + GroupChatMessageId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }

    public void updateEntity (GroupChatMessage groupChatMessage) {
        this.content = groupChatMessage.getContent();
    }
}