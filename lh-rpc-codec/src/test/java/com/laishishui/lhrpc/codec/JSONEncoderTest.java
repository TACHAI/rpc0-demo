package com.laishishui.lhrpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Create by tachai on 2020-02-21 18:48
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class JSONEncoderTest {

    @Test
    public void encode(){
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setAge(18);
        bean.setName("jerry");

        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);
    }

}