package com.laishishui.lhrpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * Create by tachai on 2020-02-12 21:23
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
