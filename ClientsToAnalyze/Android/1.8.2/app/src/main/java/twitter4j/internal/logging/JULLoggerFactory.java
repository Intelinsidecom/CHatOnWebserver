package twitter4j.internal.logging;

/* loaded from: classes.dex */
final class JULLoggerFactory extends LoggerFactory {
    JULLoggerFactory() {
    }

    @Override // twitter4j.internal.logging.LoggerFactory
    public Logger getLogger(Class cls) {
        return new JULLogger(java.util.logging.Logger.getLogger(cls.getName()));
    }
}
