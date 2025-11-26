package twitter4j.internal.logging;

/* loaded from: classes.dex */
public abstract class Logger {
    private static final LoggerFactory LOGGER_FACTORY;
    private static final String LOGGER_FACTORY_IMPLEMENTATION = "twitter4j.loggerFactory";

    public abstract void debug(String str);

    public abstract void debug(String str, String str2);

    public abstract void error(String str);

    public abstract void error(String str, Throwable th);

    public abstract void info(String str);

    public abstract void info(String str, String str2);

    public abstract boolean isDebugEnabled();

    public abstract boolean isErrorEnabled();

    public abstract boolean isInfoEnabled();

    public abstract boolean isWarnEnabled();

    public abstract void warn(String str);

    public abstract void warn(String str, String str2);

    static {
        LoggerFactory stdOutLoggerFactory = null;
        String property = System.getProperty(LOGGER_FACTORY_IMPLEMENTATION);
        if (property != null) {
            stdOutLoggerFactory = getLoggerFactoryIfAvailable(property, property);
        }
        if (stdOutLoggerFactory == null) {
            stdOutLoggerFactory = getLoggerFactoryIfAvailable("org.slf4j.impl.StaticLoggerBinder", "twitter4j.internal.logging.SLF4JLoggerFactory");
        }
        if (stdOutLoggerFactory == null) {
            stdOutLoggerFactory = getLoggerFactoryIfAvailable("org.apache.commons.logging.Log", "twitter4j.internal.logging.CommonsLoggingLoggerFactory");
        }
        if (stdOutLoggerFactory == null) {
            stdOutLoggerFactory = getLoggerFactoryIfAvailable("org.apache.log4j.Logger", "twitter4j.internal.logging.Log4JLoggerFactory");
        }
        if (stdOutLoggerFactory == null) {
            stdOutLoggerFactory = getLoggerFactoryIfAvailable("com.google.appengine.api.urlfetch.URLFetchService", "twitter4j.internal.logging.JULLoggerFactory");
        }
        if (stdOutLoggerFactory == null) {
            stdOutLoggerFactory = new StdOutLoggerFactory();
        }
        LOGGER_FACTORY = stdOutLoggerFactory;
    }

    private static LoggerFactory getLoggerFactoryIfAvailable(String str, String str2) throws ClassNotFoundException {
        try {
            Class.forName(str);
            return (LoggerFactory) Class.forName(str2).newInstance();
        } catch (ClassNotFoundException e) {
            return null;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InstantiationException e3) {
            throw new AssertionError(e3);
        } catch (SecurityException e4) {
            return null;
        }
    }

    public static Logger getLogger(Class cls) {
        return LOGGER_FACTORY.getLogger(cls);
    }
}
