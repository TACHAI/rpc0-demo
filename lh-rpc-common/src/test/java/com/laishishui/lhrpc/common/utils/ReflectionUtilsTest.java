package com.laishishui.lhrpc.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Create by tachai on 2020-02-21 18:24
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }

    @Test
    public void getPublicMethods() {

    }

    @Test
    public void invoke() {
    }
}