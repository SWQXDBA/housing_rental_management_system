package com.example.housing_rental_management_system.Service;

import com.example.housing_rental_management_system.Dao.AdminRepository;
import com.example.housing_rental_management_system.Pojo.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUserByUserName = adminRepository.getAdminUserByUserName(username);
        if(adminUserByUserName==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        String password = adminUserByUserName.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        return new User(username,encodedPassword,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin"));
    }
}
