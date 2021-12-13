package com.example.housing_rental_management_system.Dao;

import com.example.housing_rental_management_system.Pojo.Customer;
import com.example.housing_rental_management_system.Pojo.House;
import com.example.housing_rental_management_system.Pojo.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer,Long> {
     Customer findCustomerByMyUser(MyUser MyUser);
     Customer findCustomerByIdCode(String idCode);
    
}