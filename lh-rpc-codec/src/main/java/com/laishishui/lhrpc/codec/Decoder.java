package com.laishishui.lhrpc.codec;

/**
 * 反序列化
 * Create by tachai on 2020-02-11 20:43
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
