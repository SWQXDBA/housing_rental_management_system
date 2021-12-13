package com.example.housing_rental_management_system.ViewModel;

import com.example.housing_rental_management_system.Pojo.Customer;
import com.example.housing_rental_management_system.Pojo.House;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.OneToOne;
import java.sql.Timestamp;
@Data
public class AddRentalInfoRequestViewModel {
    String customerIdCode;
    Long houseId;
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    Timestamp rentStartTime;
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    Timestamp rentEndTime;
}
