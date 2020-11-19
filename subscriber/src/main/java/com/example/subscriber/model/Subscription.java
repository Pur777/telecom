package com.example.subscriber.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "telecom", name = "subscription")
public class Subscription extends Message {

}
