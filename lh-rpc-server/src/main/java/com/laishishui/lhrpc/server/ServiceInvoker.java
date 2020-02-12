package com.laishishui.lhrpc.server;

import com.laishishui.lhrpc.Request;
import com.laishishui.lhrpc.common.utils.ReflectionUtils;

/**
 * Create by tachai on 2020-02-12 21:50
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class ServiceInvoker {

    public Object invoke(ServiceInstance service, Request request){
        return ReflectionUtils.invoke(service.getTarget(),service.getMethod(),request.getParmeters());
    }
}
