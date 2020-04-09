package com.zc.jaxb.model;

import com.zc.jaxb.Utils.DateAdapter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-09 10:10
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@Getter
@Setter
public class Person {


    private int id;

    @XmlElement(nillable = true)
    private String name;

    @XmlElement(required = true)
    private String gender;

    @XmlElement
    private String addr;

    @XmlElement
    private String area;


    @XmlElement
    private Car car;

    @XmlElement
    @XmlElementWrapper(name = "MyHouse")
    private Set<House>  houses = new HashSet<>();

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date data;


    public Person() {

    }

    public Person( String name, String gender, String addr, String area) {
        this.name = name;
        this.gender = gender;
        this.addr = addr;
        this.area = area;
        houses.add(new House("ShengZheng", "108", "001"));
        houses.add(new House("BeiJing", "187", "002"));
        data = new Date();
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
