package com.zc.refactoring.case1.update;

/**
 *
 * @author CoreyChen Zhang
 * @version 2021/3/25 23:38
 * @modified
 */
public class main {

    public static void main(String[] args) {
        Customer customer = new Customer("zhangsan");
        Rental rental = new Rental(new Movie("遥远的救世主", Movie.NEW_RELEASE), 5);
        Rental rental2 = new Rental(new Movie("三体", Movie.REGULAR), 3);
        Rental rental3 = new Rental(new Movie("哈利波特", Movie.CHILDRENS), 1);
        customer.addRental(rental);
        customer.addRental(rental2);
        customer.addRental(rental3);
        System.out.println(customer.statement());
    }
}
