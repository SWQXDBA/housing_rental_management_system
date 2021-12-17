package com.example.housing_rental_management_system.ViewModel;

import com.example.housing_rental_management_system.Pojo.House;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HouseViewModel {
    String name;
    //地段
    String location;
    //房屋面积，平米
    float area;
    //可以容纳几名房客
    int capacity;

    //每个月每个人的租金
    int cost;
    public House getEntity(){
        return new House(name,location,area,capacity,cost);
    }
}
