package com.laishishui.lhrpc.example;

import com.laishishui.lhrpc.server.RpcServer;

/**
 * Create by tachai on 2020-02-21 20:02
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class Service {

    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class,new CalcServiceImpl());
        server.start();
    }
}
