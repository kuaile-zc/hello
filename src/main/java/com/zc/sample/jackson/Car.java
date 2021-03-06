package com.zc.sample.jackson;

import java.math.BigDecimal;

public class Car {

    public Car() {
    }

    public Car(String name, BigDecimal price, Double speed) {
        this.name = name;
        this.price = price;
        this.speed = speed;
    }

    private String name;

    private BigDecimal price;

    private Double speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }
}
