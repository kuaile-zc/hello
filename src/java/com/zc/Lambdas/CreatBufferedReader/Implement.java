package com.zc.Lambdas.CreatBufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 描述:
 *
 * @author zc
 * @create 2019-03-06 20:57
 */
public class Implement {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("config\\data.txt")) ){
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String oneLine = processFile((BufferedReader b)-> b.readLine());
        System.out.println(oneLine);
    }
}
