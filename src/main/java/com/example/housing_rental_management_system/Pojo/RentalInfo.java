package com.example.housing_rental_management_system.Pojo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class RentalInfo extends EntityTimes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    Customer customer;
    @ManyToOne
    House house;
    Timestamp rentStartTime;
    Timestamp rentEndTime;

}
