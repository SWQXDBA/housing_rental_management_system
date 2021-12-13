package com.example.housing_rental_management_system.Dao;

import com.example.housing_rental_management_system.Pojo.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House,Long> {
    House findHouseById(Long id);
}