package com.example.publisher.model;

import java.util.Date;

public class Message {

    private Integer id;

    private Integer msisdn;

    private Action action;

    private Date timestamp;

    public Message() {
    }

    public Message(Integer id, Integer msisdn, Action action, Date timestamp) {
        this.id = id;
        this.msisdn = msisdn;
        this.action = action;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Integer msisdn) {
        this.msisdn = msisdn;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
