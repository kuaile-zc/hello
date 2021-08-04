package com.zc.Test;

import com.alibaba.fastjson.JSON;
import com.zc.Test.model.Body;
import com.zc.Test.model.Data;


import java.util.ArrayList;
import java.util.List;

/**
 * @author CoreyChen Zhang
 * @date 2021/8/4 16:49
 * @modified
 */
public class JsonTest {

    public static void main(String[] args) {
        JsonTest jsonTest = new JsonTest();
        jsonTest.test();
    }

    private void test(){
        String str = "{\n" +
                "  \"body\": [\n" +
                "    {\n" +
                "      \"shop_id\": \"0087\",\n" +
                "      \"fence_id\": \"0087_zy\",\n" +
                "      \"fence_name\": \"0087{zy}\\u56f4\\u680f\",\n" +
                "      \"fence_type\": \"polygon\",\n" +
                "      \"gps\": [\n" +
                "        {\n" +
                "          \"type\": \"polygon\",\n" +
                "          \"lnglats\": [\n" +
                "            [\n" +
                "              113.3376216888428,\n" +
                "              23.16174700291702\n" +
                "            ],\n" +
                "            [\n" +
                "              113.3372783660889,\n" +
                "              23.15472359953004\n" +
                "            ],\n" +
                "            [\n" +
                "              113.3436298370361,\n" +
                "              23.15480251622036\n" +
                "            ],\n" +
                "            [\n" +
                "              113.3434581756592,\n" +
                "              23.16135243945651\n" +
                "            ],\n" +
                "            [\n" +
                "              113.3376216888428,\n" +
                "              23.16174700291702\n" +
                "            ]\n" +
                "          ]\n" +
                "        }\n" +
                "      ],\n" +
                "      \"area\": \"0\",\n" +
                "      \"time\": \"07:00-23:00\",\n" +
                "      \"price\": \"0\",\n" +
                "      \"fee\": null\n" +
                "    }\n" +
                "  ]\n" +
                "}";

//        String str2 = "{\"body\":[{\"fence_name\":\"bbb\",\"shop_id\":\"aaa\"}]}";
//        com.zc.Test.model.Data data1 = new Data();
//        Body body = new Body();
//        List<Body> bodies = new ArrayList<>();
//        body.setShop_id("aaa");
//        body.setFence_name("bbb");
//        bodies.add(body);
//        data1.setBody(bodies);
//        String s = JSON.toJSONString(data1);
//        System.out.println(s);
        Data data = JSON.parseObject(str, Data.class);
        System.out.println(JSON.toJSONString(data));
    }


}
