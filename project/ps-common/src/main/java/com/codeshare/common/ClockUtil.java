package com.codeshare.common;

/**
 * Created by zhaojun on 2018/7/3.
 **/

public class ClockUtil {

    private static final long startTimeMicro = System.currentTimeMillis()*1000L;

    private static final long startTimeNano = startTimeMicro*1000L;

    private static final long startTick = System.nanoTime();

    /**
     * 获取当前微秒时间戳
     * @return
     */
    public static long getCurrentTimeMicro() {
        return (System.nanoTime() - startTick) / 1000L + startTimeMicro;
    }

    /**
     * 获取纳秒时间戳
     * @return
     */
    public static long getCurrentTimeNano() {
        return System.nanoTime() - startTick + startTimeNano;
    }
}
