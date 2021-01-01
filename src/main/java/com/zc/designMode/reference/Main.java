package com.zc.designMode.reference;

/**
 *
 * 文档：java中的四种引用类型.note
 * 链接：http://note.youdao.com/noteshare?id=f4da15b2e9736575c5a107fe394cdc55&sub=A53DEA71AD4C4111A7857F0927C7C771
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
