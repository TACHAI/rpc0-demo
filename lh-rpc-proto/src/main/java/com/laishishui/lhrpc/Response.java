package com.laishishui.lhrpc;

import lombok.Data;

/**
 * rpc的返回
 * Create by tachai on 2020-02-11 20:15
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
public class Response {
    /*
     * 服务返回码，0-成功，非0失败
     */
    private int code=0;
    /*
     * 具体是错误信息
     */
    private String message;
    /*
     * 返回的数据
     */
    private Object data;
}
