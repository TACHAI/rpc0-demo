package com.laishishui.lhrpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RPC的请求
 * Create by tachai on 2020-02-11 20:12
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private ServiceDescriptor service;
    private Object[] parmeters;
}
