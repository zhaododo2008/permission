package com.codeshare.common;

import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.ServerSpan;
import com.twitter.zipkin.gen.Span;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by zhaojun on 2018/7/3.
 **/

public class BraveUtil implements ApplicationContextAware {

    private static Brave brave;

    public final static String NO_SPAN = "-NO SPAN";

    public final static String NOT_SAMPLED = "-NOT SAMPLED";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        brave = applicationContext.getBean("brave",Brave.class);
    }

    /**
     * 获取当前的traceId
     */
    public static String getCurrentTraceId() {
        if (null == brave || null == brave.serverSpanThreadBinder()) {
            return NO_SPAN;
        }
        ServerSpan serverSpan = brave.serverSpanThreadBinder().getCurrentServerSpan();
        if (null == serverSpan) {
            return NO_SPAN;
        }
        if (null == serverSpan.getSample() || !serverSpan.getSample()) {
            return NOT_SAMPLED;
        }
        return traceIdString(serverSpan.getSpan());
    }

    /**
     * 获取当前的spanId
     */
    public static String getCurrentSpanId() {
        if (null == brave || null == brave.serverSpanThreadBinder()) {
            return NO_SPAN;
        }
        ServerSpan serverSpan = brave.serverSpanThreadBinder().getCurrentServerSpan();
        if (null == serverSpan) {
            return NO_SPAN;
        }
        if (null == serverSpan.getSample() || !serverSpan.getSample()) {
            return NOT_SAMPLED;
        }
        return spanIdString(serverSpan.getSpan());
    }

    /**
     * 获取当前微秒时间戳
     * @return 微秒时间戳
     */
    public static long getCurrentTimeMicro() {
        if (null != brave && null != brave.clock()) {
            return brave.clock().currentTimeMicroseconds();
        }
        return ClockUtil.getCurrentTimeMicro();
    }

    /**
     * 获取brave实例
     * @return
     */
    public static Brave getBrave() {
        return brave;
    }


    /**
     * 获取当前serverSpan
     * @return
     */
    public static ServerSpan getCurrentServerSpan() {
        if (null == brave || null == brave.serverSpanThreadBinder()) {
            return ServerSpan.EMPTY;
        }
        return brave.serverSpanThreadBinder().getCurrentServerSpan();
    }

    public static String spanIdString(Span span) {
        if (null == span) {
            return NO_SPAN;
        }
        long spanId = span.getId();
        char[] result = new char[16];
        writeHexLong(result, 0, spanId);
        return new String(result);
    }

    private static String traceIdString(Span span) {
        if (null == span) {
            return NO_SPAN;
        }
        long traceIdHigh = span.getTrace_id_high();
        long traceId = span.getTrace_id();
        if (traceIdHigh != 0) {
            char[] result = new char[32];
            writeHexLong(result, 0, traceIdHigh);
            writeHexLong(result, 16, traceId);
            return new String(result);
        }
        char[] result = new char[16];
        writeHexLong(result, 0, traceId);
        return new String(result);
    }

    private static void writeHexLong(char[] data, int pos, long v) {
        writeHexByte(data, pos + 0,  (byte) ((v >>> 56L) & 0xff));
        writeHexByte(data, pos + 2,  (byte) ((v >>> 48L) & 0xff));
        writeHexByte(data, pos + 4,  (byte) ((v >>> 40L) & 0xff));
        writeHexByte(data, pos + 6,  (byte) ((v >>> 32L) & 0xff));
        writeHexByte(data, pos + 8,  (byte) ((v >>> 24L) & 0xff));
        writeHexByte(data, pos + 10, (byte) ((v >>> 16L) & 0xff));
        writeHexByte(data, pos + 12, (byte) ((v >>> 8L) & 0xff));
        writeHexByte(data, pos + 14, (byte)  (v & 0xff));
    }

    private static final char[] HEX_DIGITS =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void writeHexByte(char[] data, int pos, byte b) {
        data[pos + 0] = HEX_DIGITS[(b >> 4) & 0xf];
        data[pos + 1] = HEX_DIGITS[b & 0xf];
    }
}
