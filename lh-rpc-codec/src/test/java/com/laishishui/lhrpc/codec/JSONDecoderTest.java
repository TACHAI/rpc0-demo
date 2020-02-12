package com.laishishui.lhrpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Create by tachai on 2020-02-11 20:51
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class JSONDecoderTest {

    @Test
    public void encode(){
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("smgeek");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);
        //assertNotNull(bytes);
        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes,TestBean.class);
        assertEquals(bean.getName(),bean2.getName());
    }

}