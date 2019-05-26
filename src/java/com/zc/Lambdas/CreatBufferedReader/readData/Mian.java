package com.zc.Lambdas.CreatBufferedReader.readData;

import java.io.*;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-05-26 22:23
 */
public class Mian {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\readme.txt");
        InputStream inputStream = new FileInputStream(file);
        byte[] head = new byte[3];
        inputStream.read(head);
        System.out.println(head[0]);
        System.out.println(head[1]);
        System.out.println(head[2]);


        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        for (int i=0;i<10 ;i++){
            String lineString = reader.readLine();
            if (lineString!=null){
                System.out.println(lineString);
            }else {
                break;
            }

        }
    }
}
