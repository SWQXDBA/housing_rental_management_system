package com.example.housing_rental_management_system.Dao;

import com.example.housing_rental_management_system.Pojo.Customer;
import com.example.housing_rental_management_system.Pojo.House;
import com.example.housing_rental_management_system.Pojo.RentalInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RentalInfoRepository extends CrudRepository<RentalInfo,Long> {
    List<RentalInfo> findRentalInfosByCustomerAndRentEndTimeAfter(Customer customer, Timestamp after);
    List<RentalInfo> findRentalInfosByHouse(House house);
    List<RentalInfo> findRentalInfosByCustomer(Customer customer);
}