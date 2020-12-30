package com.zc.designMode.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 雇员实体类
 * @author CoreyChen Zhang
 * @version 2020/12/30 17:01
 * @modified
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String id;

    private String name;

    private String department;

    private String phone;

    public Employee(String id){
        this.id = id;
        getDateFromInfoCenter();
    }

    private void getDateFromInfoCenter(){
        /**
         * 通过数据库查询雇员信息
         * 此处为mock数据
         */
        this.name = "zhangsan";
        this.department = "testDepet";
        this.phone = "1001001";

    }
}
