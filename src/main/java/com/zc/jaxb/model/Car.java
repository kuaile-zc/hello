package com.zc.jaxb.model;

import lombok.*;

import javax.xml.bind.annotation.*;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-09 14:52
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class Car {

    @XmlValue
    private String value = "";

    @XmlAttribute
    private String CarName;

    @XmlAttribute
    private String CarLever;



    public Car() {
    }


    public Car(String carName, String carLever) {
        CarName = carName;
        CarLever = carLever;
    }
}
