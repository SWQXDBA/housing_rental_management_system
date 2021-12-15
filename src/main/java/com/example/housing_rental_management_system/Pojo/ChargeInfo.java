package com.example.housing_rental_management_system.Pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
public class ChargeInfo extends EntityTimes{
    @Id
    Long id;
    String type;
    Timestamp chargeTime;
    int money;
    @OneToOne
    Customer customer;
}