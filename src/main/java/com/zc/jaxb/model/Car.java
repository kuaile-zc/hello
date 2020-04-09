package com.zc.jaxb.model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-09 14:52
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @XmlAttribute
    private String CarName;

    @XmlAttribute
    private String CarLever;
}
