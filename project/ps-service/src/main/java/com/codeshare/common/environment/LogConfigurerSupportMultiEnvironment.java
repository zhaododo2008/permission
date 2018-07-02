package com.codeshare.common.environment;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Created by zhaojun on 2018/7/2.
 **/

public class LogConfigurerSupportMultiEnvironment {

    public static void registLogConfiguration(String logConfigLocation) throws FileNotFoundException, JoranException {
        String resolvedLocation = SystemPropertyUtils.resolvePlaceholders(logConfigLocation);
        if (resolvedLocation.toLowerCase().endsWith(".xml")) {
            URL url = ResourceUtils.getURL(resolvedLocation);
            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            loggerContext.reset();
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(loggerContext);
            joranConfigurator.doConfigure(url);
        }
    }
}
