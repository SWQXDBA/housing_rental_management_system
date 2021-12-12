package com.example.housing_rental_management_system.Pojo;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
//@ApiModel(value ="管理员")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String userName;

    String password;




    @CreationTimestamp
    Timestamp createTime;
    @UpdateTimestamp
    Timestamp updateTime;

    @Override
    public String toString() {
        return userName;
    }
}
