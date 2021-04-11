package com.zc.refactoring.case1.update;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 可扩展性第
 * 新增需求
 * 1.输出HTML格式 需要大段代码
 * 2.新增租赁书类型
 * 3.改变积分或者租金模式  代码十分难以修改
 *
 * 1.改造目标 将statement 剥离开
 * 2.你用多肽取消switch 和 if
 * @author CoreyChen Zhang
 * @version 2021/3/25 23:31
 * @modified
 */
public class Customer {

    private String _name; // 姓名
    private Vector _rentals = new Vector(); // 租借记

    public Customer(String name) {
        _name = name;
    };

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {

            Rental rental = (Rental) rentals.nextElement(); // 取得一笔租借记。
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.gainAmount()) + "\n";
        }
        // add footer lines（结尾打印）
        result += "Amount owed is " + String.valueOf(gainTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(gainTotalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    //获取当前用户全部租金
    private double gainTotalAmount(){
        return _rentals.stream().mapToDouble(_rental -> ((Rental)_rental).gainAmount()).sum();
    }

    private int gainTotalFrequentRenterPoints(){
        return _rentals.stream().mapToInt(_rental -> ((Rental)_rental).gainFrequentRenterPoints()).sum();
    }


}
