package com.example.housing_rental_management_system.Dao;

import com.example.housing_rental_management_system.Pojo.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser,Long> {
    MyUser getUserByUserName(String UserName);
}
