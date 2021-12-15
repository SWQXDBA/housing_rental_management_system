package com.example.housing_rental_management_system.Controller;

import com.example.housing_rental_management_system.Dao.*;
import com.example.housing_rental_management_system.Pojo.AjaxResult;
import com.example.housing_rental_management_system.Pojo.ChargeInfo;
import com.example.housing_rental_management_system.Pojo.Customer;
import com.example.housing_rental_management_system.Service.UserService;
import com.example.housing_rental_management_system.ViewModel.AddRentalInfoRequestViewModel;
import com.example.housing_rental_management_system.ViewModel.ChargeInfoViewModel;
import org.omg.stub.java.rmi._Remote_Stub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("charge")
@RolesAllowed("ROLE_admin")
public class ChargeInfoController{
    UserService userService;
    @Autowired
    MyUserRepository myUserRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    RentalInfoRepository rentalInfoRepository;
    @Autowired
    ChargeInfoRepository chargeInfoRepository;


    /**
     * 新增一条收费信息
     * @param viewModel
     * @return
     */
    @RolesAllowed("ROLE_admin")
    @PostMapping("add" )
    public AjaxResult add(@RequestBody ChargeInfoViewModel viewModel) {
        Customer customer = customerRepository.findCustomerByIdCode(viewModel.getCustomerIdCode());
        if(customer==null){
            return AjaxResult.error("用户不存在!");
        }
        ChargeInfo chargeInfo = new ChargeInfo(0L,viewModel.getType(),viewModel.getChargeTime(),viewModel.getMoney(),customer);
        chargeInfoRepository.save(chargeInfo);
        return AjaxResult.success("添加成功");
    }
}