package com.example.housing_rental_management_system.Dao;

import com.example.housing_rental_management_system.Pojo.ChargeInfo;
import org.omg.CORBA.Current;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeInfoRepository extends CrudRepository<ChargeInfo,Long> {
    
}