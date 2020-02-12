package com.laishishui.lhrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 * Create by tachai on 2020-02-11 21:27
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface RequestHandler {
    void onRequest(InputStream recive, OutputStream toResp);
}
