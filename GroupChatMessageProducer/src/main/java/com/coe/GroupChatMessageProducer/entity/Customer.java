package com.coe.GroupChatMessageProducer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

    enum CustomerStatus { ONLINE, OFFLINE }
    public class Customer {
        private int id;
        private String name;
        private String preferredName;
        private String phoneNumber;
        private String email;
        private CustomerStatus status;
        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        private Date createDate;

        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        private Date lastTimeOnline;




        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getPreferredName() {
            return preferredName;
        }
        public void setPreferredName(String preferredName) {
            this.preferredName = preferredName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public CustomerStatus getStatus() {
            return status;
        }
        public void setStatus(CustomerStatus status) {
            this.status = status;
        }

        public Date getCreateDate() {
            return createDate;
        }
        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public Date getLastTimeOnline() {
            return lastTimeOnline;
        }
        public void setLastTimeOnline(Date lastTimeOnline) {
            this.lastTimeOnline = lastTimeOnline;
        }
    }
