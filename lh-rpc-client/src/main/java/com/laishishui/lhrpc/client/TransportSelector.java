package com.laishishui.lhrpc.client;

import com.laishishui.lhrpc.Peer;
import com.laishishui.lhrpc.transport.TransportClient;

import java.util.List;

/**
 * Create by tachai on 2020-02-12 22:15
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface TransportSelector {
    /**
     * 初始化selector
     * @param peers
     * @param count
     * @param clazz
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient>clazz);

    /**
     * 选择一个transport与server做交互
     * @return  网络client
     */
    TransportClient select();

    /**
     * 释放用完client
     * @param client
     */
    void release(TransportClient client);

    void close();

}
