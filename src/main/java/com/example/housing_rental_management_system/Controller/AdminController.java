package com.example.housing_rental_management_system.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

/*
@DenyAll 拒绝所有的访问
@PermitAll 同意所有的访问
@RolesAllowed 用法和 5. 中的 @Secured 一样。
*/
@RestController
@RequestMapping("admin")
@RolesAllowed("ROLE_admin")
public class AdminController {

}
