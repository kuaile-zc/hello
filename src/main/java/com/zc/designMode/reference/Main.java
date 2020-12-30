package com.zc.designMode.reference;

/**
 * 通过软应用实现高速缓存
 *
 * @author CoreyChen Zhang
 * @version 2020/12/30 16:59
 * @modified
 */
public class Main {
    public static void main(String[] args) {
        EmployeeCache employeeCache = EmployeeCache.getInstance();
        Employee employee = employeeCache.getEmployee("123");
        System.out.println(employee);
    }
}
