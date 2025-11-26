package org.jboss.netty.handler.logging;

import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.logging.InternalLogLevel;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class LoggingHandler implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    private static final InternalLogLevel DEFAULT_LEVEL = InternalLogLevel.DEBUG;
    private final boolean hexDump;
    private final InternalLogLevel level;
    private final InternalLogger logger;

    public LoggingHandler() {
        this(true);
    }

    public LoggingHandler(Class cls) {
        this(cls, true);
    }

    public LoggingHandler(Class cls, InternalLogLevel internalLogLevel) {
        this(cls, internalLogLevel, true);
    }

    public LoggingHandler(Class cls, InternalLogLevel internalLogLevel, boolean z) {
        if (cls == null) {
            throw new NullPointerException("clazz");
        }
        if (internalLogLevel == null) {
            throw new NullPointerException("level");
        }
        this.logger = InternalLoggerFactory.getInstance(cls);
        this.level = internalLogLevel;
        this.hexDump = z;
    }

    public LoggingHandler(Class cls, boolean z) {
        this(cls, DEFAULT_LEVEL, z);
    }

    public LoggingHandler(String str) {
        this(str, true);
    }

    public LoggingHandler(String str, InternalLogLevel internalLogLevel, boolean z) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (internalLogLevel == null) {
            throw new NullPointerException("level");
        }
        this.logger = InternalLoggerFactory.getInstance(str);
        this.level = internalLogLevel;
        this.hexDump = z;
    }

    public LoggingHandler(String str, boolean z) {
        this(str, DEFAULT_LEVEL, z);
    }

    public LoggingHandler(InternalLogLevel internalLogLevel) {
        this(internalLogLevel, true);
    }

    public LoggingHandler(InternalLogLevel internalLogLevel, boolean z) {
        if (internalLogLevel == null) {
            throw new NullPointerException("level");
        }
        this.logger = InternalLoggerFactory.getInstance(getClass());
        this.level = internalLogLevel;
        this.hexDump = z;
    }

    public LoggingHandler(boolean z) {
        this(DEFAULT_LEVEL, z);
    }

    public InternalLogLevel getLevel() {
        return this.level;
    }

    public InternalLogger getLogger() {
        return this.logger;
    }

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        log(channelEvent);
        channelHandlerContext.sendDownstream(channelEvent);
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        log(channelEvent);
        channelHandlerContext.sendUpstream(channelEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void log(org.jboss.netty.channel.ChannelEvent r6) {
        /*
            r5 = this;
            org.jboss.netty.logging.InternalLogger r1 = r5.getLogger()
            org.jboss.netty.logging.InternalLogLevel r2 = r5.level
            boolean r1 = r1.isEnabled(r2)
            if (r1 == 0) goto L5e
            java.lang.String r2 = r6.toString()
            boolean r1 = r5.hexDump
            if (r1 == 0) goto L69
            boolean r1 = r6 instanceof org.jboss.netty.channel.MessageEvent
            if (r1 == 0) goto L69
            r0 = r6
            org.jboss.netty.channel.MessageEvent r0 = (org.jboss.netty.channel.MessageEvent) r0
            r1 = r0
            java.lang.Object r3 = r1.getMessage()
            boolean r3 = r3 instanceof org.jboss.netty.buffer.ChannelBuffer
            if (r3 == 0) goto L69
            java.lang.Object r1 = r1.getMessage()
            org.jboss.netty.buffer.ChannelBuffer r1 = (org.jboss.netty.buffer.ChannelBuffer) r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r3 = " - (HEXDUMP: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r1 = org.jboss.netty.buffer.ChannelBuffers.hexDump(r1)
            java.lang.StringBuilder r1 = r2.append(r1)
            r2 = 41
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
        L4b:
            boolean r2 = r6 instanceof org.jboss.netty.channel.ExceptionEvent
            if (r2 == 0) goto L5f
            org.jboss.netty.logging.InternalLogger r2 = r5.getLogger()
            org.jboss.netty.logging.InternalLogLevel r3 = r5.level
            org.jboss.netty.channel.ExceptionEvent r6 = (org.jboss.netty.channel.ExceptionEvent) r6
            java.lang.Throwable r4 = r6.getCause()
            r2.log(r3, r1, r4)
        L5e:
            return
        L5f:
            org.jboss.netty.logging.InternalLogger r2 = r5.getLogger()
            org.jboss.netty.logging.InternalLogLevel r3 = r5.level
            r2.log(r3, r1)
            goto L5e
        L69:
            r1 = r2
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.logging.LoggingHandler.log(org.jboss.netty.channel.ChannelEvent):void");
    }
}
