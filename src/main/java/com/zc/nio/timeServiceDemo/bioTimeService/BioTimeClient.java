package com.zc.nio.timeServiceDemo.bioTimeService;

import com.zc.nio.timeServiceDemo.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-19 10:17
 */
public class BioTimeClient {

    public static void main(String[] args) {
        int port = 8080;

        //Get port from input.
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                //TODO
            }
        }
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;


        try {
            socket = new Socket(Constant.LOCAL_HOST, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(Constant.QUERY_TIME_ORDER);
            System.out.println("Send orderservice succeed");
            String resp = in.readLine();
            System.out.println("Response now is : "+resp);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null){
                out.close();
            }

            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
