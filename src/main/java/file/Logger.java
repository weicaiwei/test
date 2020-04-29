package org.smslib.helper;

/**
 * @ClassName: Logger
 * @Description: 替换logger实现
 * @auther: caiwei
 * @date: 2019/9/29 00:17
 */


import ch.qos.logback.classic.Level;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Logger {
    private static Logger logger = new Logger();
    org.slf4j.Logger logbackLogger;
    private static final String FQCN = Logger.class.getName();

    protected Logger() {
        if (System.getProperties().getProperty("java.vm.name").equalsIgnoreCase("ikvm.net")) {
            File f = new File("log4j.properties");
            if (!f.exists()) {
                this.logbackLogger = null;
            } else {
                this.logbackLogger = LoggerFactory.getLogger("smslib");
            }
        } else {
            this.logbackLogger = LoggerFactory.getLogger("smslib");
        }

    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }

    public static void setInstance(Logger logger) {
        logger = logger;
    }

    /**
     * @Title: logInfo
     * @Description: TODO
     * @param message
    * @param e
    * @param gatewayId
     * @return: void
     * @throws:
     * @date: 2019/12/5 20:19
     */

    /**
     * @Title: logInfo
     * @Description: TODO
     * @param message
    * @param e
    * @param gatewayId
     * @return: void
     * @throws:
     * @date: 2019/12/5 20:21
     */
    /**
     * @Title: logInfo
     * @Description: TODO
     * @params:
     * @return: void
     * @throws:
     * @date: 2019/12/5 20:23
     */
    /**
     * @Title: logInfo
     * @Description: TODO
     * @params:[message, e, gatewayId]
     * @return: void
     * @throws:
     * @date: 2019/12/5 20:30
     *
     *
     */

    /**
     * @Title: logInfo
     * @Description: TODO
     * @params: [message, e, gatewayId]
     * @return: void
     * @throws:
     * @date: 2019/12/5 20:32
     */
    public void logInfo(String message, Exception e, String gatewayId) {
        if (this.logbackLogger != null) {
            this.logbackLogger.info(FQCN, Level.INFO, this.formatMessage(message, gatewayId), e);
        }
    }

    public void logWarn(String message, Exception e, String gatewayId) {
        if (this.logbackLogger != null) {
            this.logbackLogger.info(FQCN, Level.WARN, this.formatMessage(message, gatewayId), e);
        }
    }

    public void logDebug(String message, Exception e, String gatewayId) {
        if (this.logbackLogger != null) {
            this.logbackLogger.info(FQCN, Level.DEBUG, this.formatMessage(message, gatewayId), e);
        }
    }

    public void logError(String message, Exception e, String gatewayId) {
        if (this.logbackLogger != null) {
            this.logbackLogger.info(FQCN, Level.ERROR, this.formatMessage(message, gatewayId), e);
        }
    }

    private String formatMessage(String message, String gatewayId) {
        return gatewayId == null ? message : "GTW: " + gatewayId + ": " + message;
    }
}
