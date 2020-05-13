package com.zc.lambdas.demo;

import com.zc.lambdas.demo.model.IntObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: This is Map<String,List<IntObject>> -> Map<String,Integer>
 *
 * @author Corey Zhang
 * @create 2020-04-18 10:07
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,List<IntObject>> origin = new HashMap<>();
        Map<String,Integer> ret = new HashMap<>();

        List<IntObject> value1 = new ArrayList<>();
        value1.add(new IntObject(1) );
        value1.add(new IntObject(6) );

        List<IntObject> value2 = new ArrayList<>();
        value2.add(new IntObject(100) );
        value2.add(new IntObject(0) );

        List<IntObject> value3 = new ArrayList<>();
        value3.add(new IntObject(90) );
        value3.add(new IntObject(5) );

        origin.put("Key1",value1);
        origin.put("Key2",value2);
        origin.put("Key3",value3);

        ret = origin.entrySet().parallelStream().collect(Collectors.toMap(
                originkey -> originkey.getKey() ,
                originvalue -> (int)originvalue.getValue().stream().mapToDouble(IntObject::getId).sum()
        ));

        System.out.println(ret);
    }
}
