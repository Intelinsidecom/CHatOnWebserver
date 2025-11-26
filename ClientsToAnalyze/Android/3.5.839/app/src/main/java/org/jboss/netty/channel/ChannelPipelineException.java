package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class ChannelPipelineException extends ChannelException {
    public ChannelPipelineException() {
    }

    public ChannelPipelineException(String str, Throwable th) {
        super(str, th);
    }

    public ChannelPipelineException(Throwable th) {
        super(th);
    }
}
