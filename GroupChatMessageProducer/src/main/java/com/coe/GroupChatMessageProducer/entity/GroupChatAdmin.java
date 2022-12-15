package com.coe.GroupChatMessageProducer.entity;

public class GroupChatAdmin {
    private int id;
    private Customer customer_id;
    private GroupChat group_chat_id;


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

    public GroupChat getGroup_chat_id() {return group_chat_id;}
    public void setGroup_chat_id(GroupChat group_chat_id) {this.group_chat_id = group_chat_id;}
}
