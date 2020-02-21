package com.laishishui.lhrpc.server;

import com.laishishui.lhrpc.Request;
import com.laishishui.lhrpc.Response;
import com.laishishui.lhrpc.codec.Decoder;
import com.laishishui.lhrpc.codec.Encoder;
import com.laishishui.lhrpc.common.utils.ReflectionUtils;
import com.laishishui.lhrpc.transport.RequestHandler;
import com.laishishui.lhrpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Create by tachai on 2020-02-12 21:49
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(){
        this.config=new RpcServerConfig();
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(),this.handler);

        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());

        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass,T bean){
        serviceManager.register(interfaceClass,bean);
    }

    public void start(){
        this.net.start();
    }
    public void stop(){
        this.net.stop();
    }
    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream recive, OutputStream toResp) {
            Response resp = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(recive,recive.available(),true);
                Request request = decoder.decode(inBytes,Request.class);
                ServiceInstance sis = serviceManager.lookup(request);
                serviceInvoker.invoke(sis,request);
                Object ret = serviceInvoker.invoke(sis,request);
                resp.setData(ret);
            }catch (IOException e){
                log.warn(e.getMessage(),e);
                resp.setCode(1);
                resp.setMessage("RpcServer got error: "+e.getClass().getName()+":"+e.getMessage());
            }finally {
                try {
                    byte[] outBytes = encoder.encode(resp);
                    toResp.write(outBytes);
                }catch (IOException e){
                    log.warn(e.getMessage(),e);
                }

            }
        }
    };
}
