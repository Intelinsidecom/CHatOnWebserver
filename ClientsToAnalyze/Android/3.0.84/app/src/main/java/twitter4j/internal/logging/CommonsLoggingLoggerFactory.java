package twitter4j.internal.logging;

import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
final class CommonsLoggingLoggerFactory extends LoggerFactory {
    CommonsLoggingLoggerFactory() {
    }

    @Override // twitter4j.internal.logging.LoggerFactory
    public Logger getLogger(Class cls) {
        return new CommonsLoggingLogger(LogFactory.getLog(cls));
    }
}
