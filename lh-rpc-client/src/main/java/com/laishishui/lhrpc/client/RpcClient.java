package com.laishishui.lhrpc.client;

import com.laishishui.lhrpc.codec.Decoder;
import com.laishishui.lhrpc.codec.Encoder;
import com.laishishui.lhrpc.common.utils.ReflectionUtils;
import javafx.scene.control.TreeViewBuilder;

import java.lang.reflect.Proxy;

/**
 * Create by tachai on 2020-02-12 22:39
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient(){
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config){
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.encoder.getClass());
        this.decoder = ReflectionUtils.newInstance(this.decoder.getClass());
        this.selector = ReflectionUtils.newInstance(this.selector.getClass());

        this.selector.init(this.config.getServers(),this.config.getConnectCount(),this.config.getTransportClass());
    }

    public <T> T getProxy(Class<T> clazz){
        return(T) Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{clazz},new RemoteInvoker(clazz,encoder,decoder,selector));
    }
}
