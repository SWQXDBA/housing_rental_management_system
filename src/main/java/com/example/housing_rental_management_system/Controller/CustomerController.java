package com.example.housing_rental_management_system.Controller;

import com.example.housing_rental_management_system.Dao.HouseRepository;
import com.example.housing_rental_management_system.Dao.MyUserRepository;
import com.example.housing_rental_management_system.Pojo.AjaxResult;
import com.example.housing_rental_management_system.Pojo.Customer;
import com.example.housing_rental_management_system.Pojo.MyUser;
import com.example.housing_rental_management_system.Dao.CustomerRepository;
import com.example.housing_rental_management_system.Dao.RentalInfoRepository;
import com.example.housing_rental_management_system.Service.UserService;
import com.example.housing_rental_management_system.ViewModel.AddCustomerRequestViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.Random;

@RestController
@RequestMapping("customer")
public class CustomerController{
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


    Random random = new Random();
    /**
     * 同时注册一个customer和MyUser进去
     * @param user
     * @return
     */
    @PermitAll
    @PostMapping("add")
    public AjaxResult add (@RequestBody AddCustomerRequestViewModel user){

        MyUser myUser = new MyUser();
        myUser.setUserName(user.getIdCode());
        myUser.setPassword(user.getPassword());

        if (!userService.addCustomer(myUser)) {
            return AjaxResult.error("用户名重复");
        }
        Customer customer = new Customer();
        customer.setIdCode(user.getIdCode());
        customer.setName(user.getName());
        customer.setPhone(user.getPhone());
        myUser = myUserRepository.getUserByUserName(user.getIdCode());
        customer.setMyUser(myUser);
        customerRepository.save(customer);
        return AjaxResult.success("添加成功!");

    }

    @Autowired
    PasswordEncoder passwordEncoder;
    @PermitAll
    @GetMapping("test")
    public AjaxResult test (){

        Random random = new Random();
        MyUser myUser = new MyUser();
        myUser.setUserName("."+random.nextInt());
        myUser.setPassword("passsword:"+random.nextInt());

        if (!userService.addCustomer(myUser)) {
            return AjaxResult.error("用户名重复");
        }
        Customer customer = new Customer();
        customer.setIdCode(random.nextInt()+" ,"+random.nextInt()+random.nextInt());

        return AjaxResult.success( customerRepository.save(customer));

    }
    @PermitAll
    @GetMapping("test2")
    public AjaxResult test2 (){

        return AjaxResult.success(passwordEncoder.encode("666pass::"+random.nextInt()));


    }
}