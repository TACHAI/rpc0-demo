package com.laishishui.lhrpc.server;

import com.laishishui.lhrpc.codec.Decoder;
import com.laishishui.lhrpc.codec.Encoder;
import com.laishishui.lhrpc.codec.JSONDecoder;
import com.laishishui.lhrpc.codec.JSONEncoder;
import com.laishishui.lhrpc.transport.HttpTransportServer;
import com.laishishui.lhrpc.transport.TransportServer;

/**
 * Create by tachai on 2020-02-12 21:18
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;

}
