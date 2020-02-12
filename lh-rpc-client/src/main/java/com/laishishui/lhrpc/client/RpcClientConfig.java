package com.laishishui.lhrpc.client;

import com.laishishui.lhrpc.Peer;
import com.laishishui.lhrpc.codec.Decoder;
import com.laishishui.lhrpc.codec.Encoder;
import com.laishishui.lhrpc.codec.JSONDecoder;
import com.laishishui.lhrpc.codec.JSONEncoder;
import com.laishishui.lhrpc.transport.HTTPTransportClient;
import com.laishishui.lhrpc.transport.TransportClient;

import java.util.Arrays;
import java.util.List;

/**
 * Create by tachai on 2020-02-12 22:30
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private  Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount =1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1",3000));
}
