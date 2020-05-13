package com.zc.nio.timeServiceDemo.timeServiceMultiplexer;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-01-05 17:41
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;

        //Get port from input.
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //TODO
            }

        }

        MultiplexerTimeService timeService = new MultiplexerTimeService(port);
        new Thread(timeService, "NIO-MultiplexerTimeService001").start();

    }
}
