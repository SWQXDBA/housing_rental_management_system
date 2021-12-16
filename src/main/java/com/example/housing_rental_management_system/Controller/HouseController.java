package com.example.housing_rental_management_system.Controller;

import com.example.housing_rental_management_system.Dao.CustomerRepository;
import com.example.housing_rental_management_system.Dao.HouseRepository;
import com.example.housing_rental_management_system.Dao.MyUserRepository;
import com.example.housing_rental_management_system.Dao.RentalInfoRepository;
import com.example.housing_rental_management_system.Pojo.*;
import com.example.housing_rental_management_system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    /**
     * 如果pageNumber = 1,pageSize  = 2 则返回 3 4
     * 如果pageNumber = 0,pageSize  = 3 则返回 1 2 3
     * @param pageNumber 第几页 从0开始
     * @param pageSize 每一页由多少条数据
     * @return
     */
    @PermitAll
    @GetMapping("getAllPage" )
    public AjaxResult getAllPage(int pageNumber,int pageSize) {

        Page<House> page = houseRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return AjaxResult.success(page.get().collect(Collectors.toList()));


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

    @PermitAll
    @GetMapping("getAll" )
    public AjaxResult getAll(){
        return AjaxResult.success(houseRepository.findAll());
    }

    /**
     *  查询所有未出租满的房源
     * @return
     */
    @PermitAll
    @GetMapping("getAllUnRented" )
    public AjaxResult getAllUnRented(){
        return AjaxResult.success(houseRepository.getHousesUnRent());
    }
}