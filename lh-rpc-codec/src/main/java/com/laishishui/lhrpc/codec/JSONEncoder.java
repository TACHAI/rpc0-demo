package com.laishishui.lhrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的序列化实现
 * Create by tachai on 2020-02-11 20:46
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
