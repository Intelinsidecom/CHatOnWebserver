package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class ChannelException extends RuntimeException {
    public ChannelException() {
    }

    public ChannelException(String str, Throwable th) {
        super(str, th);
    }

    public ChannelException(Throwable th) {
        super(th);
    }
}
