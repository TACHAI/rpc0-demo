package com.laishishui.lhrpc.codec;

/**
 * 序列化
 * Create by tachai on 2020-02-11 20:42
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface Encoder {
    byte[] encode(Object obj);
}
