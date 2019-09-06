package com.zc.sample.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import com.expedia.e3.shopsvc.shared.thirdparty.lcs.*;

public class FileTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private String CarString = "{\"name\":\"DaBen\",\"price\":350000,\"speed\":100.0}";
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        car.setName("DaBen");
        car.setPrice(new BigDecimal(350000));
        car.setSpeed(100d);
        String jsonString = MAPPER.writeValueAsString(car);
        System.out.println(jsonString);

        Car testCar = JsonObject(getFile("D:\\Task\\ridFeedLCM\\car.txt"));
        System.out.println(testCar.toString());
    }

    private static FileInputStream getFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        return inputStream;
    }

    private static Car JsonObject(InputStream inputStream) throws IOException {
        return MAPPER.readValue(inputStream, Car.class);
    }
}
