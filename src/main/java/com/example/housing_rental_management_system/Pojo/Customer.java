package com.example.housing_rental_management_system.Pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer extends EntityBase {
    @Id
    String idCode;
    String name;
    String phone;
    @OneToOne
    MyUser myUser;

}
