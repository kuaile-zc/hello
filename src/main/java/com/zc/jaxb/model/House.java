package com.zc.jaxb.model;

import lombok.Data;
import org.hamcrest.Condition;

import javax.xml.bind.annotation.*;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-09 14:58
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class House {

    public House() {
    }

    public House(String houseCity, String area, String id) {
        this.houseCity = houseCity;
        this.area = area;
        this.id = id;
    }

    @XmlElement
    private String houseCity;

    @XmlElement
    private String area;

    @XmlElement
    private String id;
}
