package com.laishishui.lhrpc.example;

import com.laishishui.lhrpc.client.RpcClient;

/**
 * Create by tachai on 2020-02-21 20:02
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class Client {


    public static void main(String[] args) {
        RpcClient client = new RpcClient();

        CalcService service = client.getProxy(CalcService.class);

        int r1= service.add(1,2);
        int r2 = service.minus(10,8);

        System.out.println(r1);
        System.out.println(r2);
    }
}
