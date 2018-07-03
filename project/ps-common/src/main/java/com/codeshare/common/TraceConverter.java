package com.codeshare.common;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Created by zhaojun on 2018/7/3.
 **/

public class TraceConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return BraveUtil.getCurrentTraceId();
    }
}
