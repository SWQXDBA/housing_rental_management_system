package com.example.housing_rental_management_system.Controller;

import com.example.housing_rental_management_system.Dao.HouseRepository;
import com.example.housing_rental_management_system.Pojo.AjaxResult;
import com.example.housing_rental_management_system.Pojo.MyUser;
import com.example.housing_rental_management_system.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.security.Principal;

/*
@DenyAll 拒绝所有的访问
@PermitAll 同意所有的访问
@RolesAllowed 用法和 5. 中的 @Secured 一样。
*/
@RestController
@RequestMapping("admin")

public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    HouseRepository houseRepository;
    @RolesAllowed("ROLE_admin")
    @PostMapping("addAdmin")
    public AjaxResult addAdmin (@RequestBody MyUser user){
        if (userService.addAdmin(user)) {
            return AjaxResult.success();
        }else{
            return AjaxResult.error("用户名重复");
        }
    }

    @PermitAll
    @PostMapping("init")
    public AjaxResult init (@RequestBody MyUser user){


        if (userService.addAdmin(user)) {
            return AjaxResult.success();
        }else{
            return AjaxResult.error("用户名重复");
        }

    }
}
