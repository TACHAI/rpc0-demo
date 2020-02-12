package com.laishishui.lhrpc.codec;


import com.alibaba.fastjson.JSON;

/**
 * 基于json的反序列化实现
 * Create by tachai on 2020-02-11 20:48
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        //return JSON.toJSONBytes();
        return null;
    }
}
