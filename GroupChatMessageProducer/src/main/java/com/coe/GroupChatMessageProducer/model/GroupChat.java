package com.coe.GroupChatMessageProducer.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GroupChat {

    private int id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date created_date;

    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_date() {
        return created_date;
    }
    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
