package com.example.housing_rental_management_system.Controller;

import com.example.housing_rental_management_system.Dao.HouseRepository;
import com.example.housing_rental_management_system.Dao.MyUserRepository;
import com.example.housing_rental_management_system.Pojo.*;
import com.example.housing_rental_management_system.Dao.CustomerRepository;
import com.example.housing_rental_management_system.Dao.RentalInfoRepository;
import com.example.housing_rental_management_system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("house")
@PermitAll
public class HouseController{
    @Autowired
    UserService userService;
    @Autowired
    MyUserRepository myUserRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    RentalInfoRepository rentalInfoRepository;

    @RolesAllowed("ROLE_admin")
    @PostMapping("add" )
    public AjaxResult add(@RequestBody House house){
        houseRepository.save(house);
        return AjaxResult.success();
    }
    @RolesAllowed("ROLE_customer")
    @GetMapping("getMyHouses" )
   public AjaxResult getMyHouses(@AuthenticationPrincipal UserDetails userDetail){

        MyUser myUser = myUserRepository.getUserByUserName(userDetail.getUsername());
        Customer customer = customerRepository.findCustomerByMyUser(myUser);

        List<RentalInfo> infos = rentalInfoRepository
                .findRentalInfosByCustomerAndRentEndTimeAfter(customer,new Timestamp(System.currentTimeMillis()));
        List<House> houses = infos.stream().map(RentalInfo::getHouse).collect(Collectors.toList());
        return AjaxResult.success(houses);
    }

    @GetMapping("getAll" )
    public AjaxResult getAll(){
        return AjaxResult.success(houseRepository.findAll());
    }
}