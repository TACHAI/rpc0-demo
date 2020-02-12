package com.laishishui.lhrpc.transport;

import com.laishishui.lhrpc.Peer;

import java.io.InputStream;

/**
 * 创建连接
 * 发送数据，并且等待响应
 * 关闭连接
 * Create by tachai on 2020-02-11 21:14
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface TransportClient {
    void connect(Peer peer);
    InputStream write(InputStream data);
    void close();
}
