package com.example.housing_rental_management_system.Pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class House extends EntityTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //房屋名称
    String name;
    //地段
    String location;
    //房屋面积，平米
    float area;
    //可以容纳几名房客
    int capacity;

    //每个月每个人的租金
    int cost;


}
