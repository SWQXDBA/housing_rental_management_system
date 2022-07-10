package com.example.housing_rental_management_system.Pojo;

import lombok.Data;
import javax.persistence.*;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
//@ApiModel(value ="管理员")
public class MyUser extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String userName;

    String password;


    //权限
    String authorities;




}
