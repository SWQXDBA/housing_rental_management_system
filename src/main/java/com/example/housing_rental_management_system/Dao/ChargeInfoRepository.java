package com.example.housing_rental_management_system.Dao;

import com.example.housing_rental_management_system.Pojo.ChargeInfo;
import org.omg.CORBA.Current;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargeInfoRepository extends CrudRepository<ChargeInfo,Long> {
    List<ChargeInfo> findChargeInfosByCustomerIdCode(Long idCode);
    List<ChargeInfo> findChargeInfosByHouseId(Long idCode);
}