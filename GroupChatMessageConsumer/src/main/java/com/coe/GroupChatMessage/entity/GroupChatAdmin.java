package com.coe.GroupChatMessage.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_chat_admin")
public class GroupChatAdmin {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",referencedColumnName ="id", nullable = false)
    private Customer customer_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_chat_id",referencedColumnName ="id", nullable = false)
    private GroupChat groupChatId;

    @OneToMany
    private List<GroupChatMessageEntity> groupChatMessage;


    //Constructor GroupChatAdmin
    public GroupChatAdmin(int id, Customer customer_id, GroupChat groupChatId) {
        this.id = id;
        this.customer_id = customer_id;
        this.groupChatId = groupChatId;
    }

    public GroupChatAdmin() {
    }

    //Getters & Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public GroupChat getGroupChatId() {return groupChatId;}
    public void setGroupChatId(GroupChat groupChatId) {this.groupChatId = groupChatId;}
}
