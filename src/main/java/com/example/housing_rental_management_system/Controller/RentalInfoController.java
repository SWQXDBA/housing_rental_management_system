package com.example.housing_rental_management_system.Controller;

import com.example.housing_rental_management_system.Dao.CustomerRepository;
import com.example.housing_rental_management_system.Dao.HouseRepository;
import com.example.housing_rental_management_system.Dao.MyUserRepository;
import com.example.housing_rental_management_system.Pojo.AjaxResult;
import com.example.housing_rental_management_system.Pojo.Customer;
import com.example.housing_rental_management_system.Pojo.House;
import com.example.housing_rental_management_system.Pojo.RentalInfo;
import com.example.housing_rental_management_system.Dao.RentalInfoRepository;
import com.example.housing_rental_management_system.Service.UserService;
import com.example.housing_rental_management_system.ViewModel.AddRentalInfoRequestViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("rentalInfo")
public class RentalInfoController{
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
    public AjaxResult add(@RequestBody AddRentalInfoRequestViewModel info){
        info.setRentEndTime(new Timestamp(System.currentTimeMillis()+100000));

        Customer customer = customerRepository.findCustomerByIdCode(info.getCustomerIdCode());
        if(customer==null){
            return AjaxResult.error("租户信息不存在!");
        }
        House house = houseRepository.findHouseById(info.getHouseId());
        if(house==null){
            return AjaxResult.error("房屋信息不存在!");
        }
        RentalInfo rentalInfo = new RentalInfo();
        rentalInfo.setHouse(house);
        rentalInfo.setCustomer(customer);
        rentalInfo.setRentStartTime(info.getRentStartTime());
        rentalInfo.setRentEndTime(info.getRentEndTime());
        rentalInfoRepository.save(rentalInfo);
        return AjaxResult.success("信息登记成功!!!");
    }

    @RolesAllowed("ROLE_admin")
    @PostMapping("getByHouse" )
    public AjaxResult getByHouse(Long houseId){
        House house = houseRepository.findHouseById(houseId);
        if(house==null){
            return AjaxResult.error("房屋信息不存在!");
        }
        List<RentalInfo> rentalInfosByHouse = rentalInfoRepository.findRentalInfosByHouse(house);
        //脱敏
        rentalInfosByHouse.forEach(r->r.getCustomer().setMyUser(null));
        return AjaxResult.success(rentalInfosByHouse);
    }

    @RolesAllowed("ROLE_admin")
    @PostMapping("getByCustomer" )
    public AjaxResult getByCustomer(String userIdCode){
        Customer customer = customerRepository.findCustomerByIdCode(userIdCode);

        if(customer==null){
            return AjaxResult.error("租户信息不存在!");
        }
        List<RentalInfo> rentalInfosByHouse = rentalInfoRepository.findRentalInfosByCustomer(customer);
        //脱敏
       rentalInfosByHouse.forEach(r->r.getCustomer().setMyUser(null));
        return AjaxResult.success(rentalInfosByHouse);
    }
}