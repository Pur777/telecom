package com.example.subscriber.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "telecom", name = "purchase")
public class Purchase extends Message {

}
