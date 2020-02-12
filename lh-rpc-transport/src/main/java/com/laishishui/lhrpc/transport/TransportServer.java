package com.laishishui.lhrpc.transport;

/**
 * 启动，监听
 * 接受请求
 * 关闭监听
 * Create by tachai on 2020-02-11 21:25
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface TransportServer {


    void init(int port,RequestHandler handler);
    void start();
    void stop();
}
