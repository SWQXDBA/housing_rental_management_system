package com.example.housing_rental_management_system.ViewModel;

import com.example.housing_rental_management_system.Pojo.MyUser;
import lombok.Data;

import javax.persistence.OneToOne;
@Data
public class AddCustomerRequestViewModel {
    String idCode;
    String name;
    String phone;
    String password;

}
