package com.example.housing_rental_management_system.Service;

import com.example.housing_rental_management_system.Dao.MyUserRepository;
import com.example.housing_rental_management_system.Pojo.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MyUserRepository userRepository;
    public boolean addAdmin(MyUser user){
        MyUser us = userRepository.getUserByUserName(user.getUserName());
        if(us!=null){
            return false;
        }
        MyUser newUser = new MyUser();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setAuthorities("ROLE_admin ROLE_customer");
        userRepository.save(newUser);
        return true;
    }

}
