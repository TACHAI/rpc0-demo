package com.laishishui.lhrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 网络传输层的一个端点
 * Create by tachai on 2020-02-11 20:08
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
