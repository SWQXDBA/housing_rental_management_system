package com.example.housing_rental_management_system.Dao;

import com.example.housing_rental_management_system.Pojo.AdminUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminUser,Long> {
    AdminUser getAdminUserByUserName(String UserName);
}
