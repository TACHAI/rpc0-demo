package com.laishishui.lhrpc.client;

import com.laishishui.lhrpc.Peer;
import com.laishishui.lhrpc.common.utils.ReflectionUtils;
import com.laishishui.lhrpc.transport.TransportClient;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create by tachai on 2020-02-12 22:21
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Slf4j
public class RandomTransportSelector implements TransportSelector {

    private List<TransportClient> clients;

    public RandomTransportSelector(){
        clients = new ArrayList<>();
    }
    /**
     * 已经连接好的client
     * @param peers
     * @param count
     * @param clazz
     */
    @Override
    public void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz) {
        count = Math.max(count,1);
        for(Peer peer:peers){
            for(int i=0;i<count;i++){
                TransportClient client = ReflectionUtils.newInstance();
                client.connect(peer);
                clients.add(client);
            }
            log.info("connect server: {}",peer);
        }
    }

    @Override
    public TransportClient select() {
        int i= new Random().nextInt(clients.size());
        return clients.remove(i);
    }

    @Override
    public void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public void close() {
        for(TransportClient client:clients){
            client.close();
        }
        clients.clear();
    }
}
