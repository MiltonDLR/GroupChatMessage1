package com.coe.GroupChatMessage.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "group_chat")
public class GroupChat {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    //Getters & Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}
}
