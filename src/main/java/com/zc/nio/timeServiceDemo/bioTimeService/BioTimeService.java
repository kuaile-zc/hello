package com.zc.nio.timeServiceDemo.bioTimeService;

import javafx.beans.binding.NumberExpression;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-19 09:51
 */
public class BioTimeService {

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

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("The time service is start input: "+port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new BioTimeHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
