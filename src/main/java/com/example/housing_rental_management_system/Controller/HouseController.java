package com.example.housing_rental_management_system.Controller;

import com.example.housing_rental_management_system.Dao.HouseRepository;
import com.example.housing_rental_management_system.Pojo.AjaxResult;
import com.example.housing_rental_management_system.Pojo.House;
import com.example.housing_rental_management_system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("house")
@RolesAllowed("ROLE_admin")
public class HouseController{
    @Autowired
    UserService userService;
    @Autowired
    HouseRepository houseRepository;
    @PermitAll
    @PostMapping("add" )
    public AjaxResult add(@RequestBody House house){
        houseRepository.save(house);
        return AjaxResult.success();
    }
}