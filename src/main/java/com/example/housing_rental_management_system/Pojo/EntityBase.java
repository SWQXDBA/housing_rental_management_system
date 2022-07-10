package com.example.housing_rental_management_system.Pojo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@MappedSuperclass
public class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @CreationTimestamp
    LocalDateTime createTime;
    @UpdateTimestamp
    LocalDateTime updateTime;
}
