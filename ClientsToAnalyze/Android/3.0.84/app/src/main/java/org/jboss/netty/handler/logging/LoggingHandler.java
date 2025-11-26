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

    public LoggingHandler(InternalLogLevel internalLogLevel) {
        this(internalLogLevel, true);
    }

    public LoggingHandler(boolean z) {
        this(DEFAULT_LEVEL, z);
    }

    public LoggingHandler(InternalLogLevel internalLogLevel, boolean z) {
        if (internalLogLevel == null) {
            throw new NullPointerException("level");
        }
        this.logger = InternalLoggerFactory.getInstance(getClass());
        this.level = internalLogLevel;
        this.hexDump = z;
    }

    public LoggingHandler(Class<?> cls) {
        this(cls, true);
    }

    public LoggingHandler(Class<?> cls, boolean z) {
        this(cls, DEFAULT_LEVEL, z);
    }

    public LoggingHandler(Class<?> cls, InternalLogLevel internalLogLevel) {
        this(cls, internalLogLevel, true);
    }

    public LoggingHandler(Class<?> cls, InternalLogLevel internalLogLevel, boolean z) {
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

    public LoggingHandler(String str) {
        this(str, true);
    }

    public LoggingHandler(String str, boolean z) {
        this(str, DEFAULT_LEVEL, z);
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

    public InternalLogger getLogger() {
        return this.logger;
    }

    public InternalLogLevel getLevel() {
        return this.level;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void log(org.jboss.netty.channel.ChannelEvent r5) {
        /*
            r4 = this;
            org.jboss.netty.logging.InternalLogger r0 = r4.getLogger()
            org.jboss.netty.logging.InternalLogLevel r1 = r4.level
            boolean r0 = r0.isEnabled(r1)
            if (r0 == 0) goto L5d
            java.lang.String r1 = r5.toString()
            boolean r0 = r4.hexDump
            if (r0 == 0) goto L68
            boolean r0 = r5 instanceof org.jboss.netty.channel.MessageEvent
            if (r0 == 0) goto L68
            r0 = r5
            org.jboss.netty.channel.MessageEvent r0 = (org.jboss.netty.channel.MessageEvent) r0
            java.lang.Object r2 = r0.getMessage()
            boolean r2 = r2 instanceof org.jboss.netty.buffer.ChannelBuffer
            if (r2 == 0) goto L68
            java.lang.Object r0 = r0.getMessage()
            org.jboss.netty.buffer.ChannelBuffer r0 = (org.jboss.netty.buffer.ChannelBuffer) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = " - (HEXDUMP: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = org.jboss.netty.buffer.ChannelBuffers.hexDump(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 41
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
        L4a:
            boolean r1 = r5 instanceof org.jboss.netty.channel.ExceptionEvent
            if (r1 == 0) goto L5e
            org.jboss.netty.logging.InternalLogger r1 = r4.getLogger()
            org.jboss.netty.logging.InternalLogLevel r2 = r4.level
            org.jboss.netty.channel.ExceptionEvent r5 = (org.jboss.netty.channel.ExceptionEvent) r5
            java.lang.Throwable r3 = r5.getCause()
            r1.log(r2, r0, r3)
        L5d:
            return
        L5e:
            org.jboss.netty.logging.InternalLogger r1 = r4.getLogger()
            org.jboss.netty.logging.InternalLogLevel r2 = r4.level
            r1.log(r2, r0)
            goto L5d
        L68:
            r0 = r1
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.logging.LoggingHandler.log(org.jboss.netty.channel.ChannelEvent):void");
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        log(channelEvent);
        channelHandlerContext.sendUpstream(channelEvent);
    }

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        log(channelEvent);
        channelHandlerContext.sendDownstream(channelEvent);
    }
}
