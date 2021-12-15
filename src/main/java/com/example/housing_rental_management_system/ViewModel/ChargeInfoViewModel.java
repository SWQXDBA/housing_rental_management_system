package com.example.housing_rental_management_system.ViewModel;

import com.example.housing_rental_management_system.Pojo.ChargeInfo;
import com.example.housing_rental_management_system.Pojo.Customer;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
@Data
public class ChargeInfoViewModel {

    ChargeInfo.ChargeType type;
    Timestamp chargeTime;
    int money;
    String customerIdCode;
    Long houseId;
}
