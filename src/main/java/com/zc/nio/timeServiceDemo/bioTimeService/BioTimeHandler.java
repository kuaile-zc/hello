package com.zc.nio.timeServiceDemo.bioTimeService;

import com.zc.nio.timeServiceDemo.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-19 09:59
 */
public class BioTimeHandler implements Runnable{

    private Socket socket;

    public BioTimeHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body == null){
                    break;
                }
                System.out.println("The time server receive order : "+body);
                currentTime = Constant.QUERY_TIME_ORDER.equalsIgnoreCase(body) ? new Date().toString() : Constant.BAD_QUERY;
                out.println(currentTime);

            }
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

            if (this.socket != null){
                try {
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
