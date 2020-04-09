package com.zc.jaxb;

import com.zc.jaxb.model.Car;
import com.zc.jaxb.model.Person;
import org.junit.Test;

import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-09 10:14
 */
public class JAXBTest {

    final String separator = File.separator;

    final String xmlFilePath = System.getProperty("user.dir")+separator+"out"+separator+"person.xml";

    @Test
    public void generateXML() throws IOException {
        Person person = new Person("abc", "Man", "BeiJing", "ChaoYang");
//        person.setName(null);
//        person.setGender(null);
        person.setCar(new Car("BenChi","B"));
        File file = new File(xmlFilePath);
        if (!file.exists()){
            file.createNewFile();
        }

        JAXBContext jc = null;
        try {
            //根据Person类生成上下文对象 Generate context objects from the Person class.
            jc = JAXBContext.newInstance(Person.class);
            //从上下文中获取Marshaller对象，用作将bean编组(转换)为xml   The Marshaller object is obtained from the context and used to marshall (Transform) the bean to XML.
            Marshaller ma = jc.createMarshaller();
            //以下是为生成xml做的一些配置 Here are some of the configuration for generation XML.
            //格式化输出，即按标签自动换行，否则就是一行 Format the output, wrap it by label, otherwise it is one line
            ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //设置编码（默认编码就是utf-8）
            ma.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //是否省略xml头信息，默认不省略（false）
            ma.setProperty(Marshaller.JAXB_FRAGMENT, false);

            //编组
            ma.marshal(person, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateBean() {
        File file = new File(xmlFilePath);
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Person.class);
            Unmarshaller uma = jc.createUnmarshaller();
            Person person = (Person) uma.unmarshal(file);
            System.out.println(person.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateXMLSimple() throws IOException {
        Person person = new Person("abc", "Man", "BeiJing", "ChaoYang");
        File file = new File(xmlFilePath);
        if (!file.exists()){
            file.createNewFile();
        }
        JAXB.marshal(person, file);
    }

    @Test
    public void generateBeanSimple() {
        File file = new File(xmlFilePath);
        Person person = JAXB.unmarshal(file, Person.class);

        System.out.println(person);
    }



}
