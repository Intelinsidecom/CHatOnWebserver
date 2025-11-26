package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.Selector;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
final class SelectorUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelectorUtil.class);
    static final int DEFAULT_IO_THREADS = Runtime.getRuntime().availableProcessors() * 2;

    SelectorUtil() {
    }

    static void select(Selector selector) throws IOException {
        try {
            selector.select(500L);
        } catch (CancelledKeyException e) {
            logger.debug(CancelledKeyException.class.getSimpleName() + " raised by a Selector - JDK bug?", e);
        }
    }
}
