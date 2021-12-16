package com.example.housing_rental_management_system.Dao;

import com.example.housing_rental_management_system.Pojo.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> {
    House findHouseById(Long id);


    @Query("select r.house from RentalInfo r where r.rentEndTime > current_timestamp group by r.house having  " +
            " count (r.house )< r.house.capacity")
    List<House> getHousesUnRent();



}