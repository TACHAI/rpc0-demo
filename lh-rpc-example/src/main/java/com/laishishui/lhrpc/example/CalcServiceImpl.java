package com.laishishui.lhrpc.example;

/**
 * Create by tachai on 2020-02-21 20:05
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a-b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}
