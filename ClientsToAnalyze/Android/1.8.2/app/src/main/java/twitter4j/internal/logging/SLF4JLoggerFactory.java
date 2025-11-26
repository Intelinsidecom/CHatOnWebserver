package twitter4j.internal.logging;

/* loaded from: classes.dex */
final class SLF4JLoggerFactory extends LoggerFactory {
    SLF4JLoggerFactory() {
    }

    @Override // twitter4j.internal.logging.LoggerFactory
    public Logger getLogger(Class cls) {
        return new SLF4JLogger(org.slf4j.LoggerFactory.getLogger(cls));
    }
}
