package com.example.housing_rental_management_system.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@Entity
@AllArgsConstructor

public class ChargeInfo extends EntityBase {
    @Id

    Long id;

    public ChargeInfo() {

    }



    public static enum ChargeType{
        //电费 水费 房费
        ELECTRICITY,WATER,ROOM
    }
    @Enumerated(value = EnumType.STRING)
    ChargeType type;
    Timestamp chargeTime;
    int money;
    @ManyToOne
    Customer customer;
    @ManyToOne
    House house;
}

