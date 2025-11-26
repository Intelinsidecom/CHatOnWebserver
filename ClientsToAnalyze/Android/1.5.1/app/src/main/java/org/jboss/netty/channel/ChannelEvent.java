package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ChannelEvent {
    Channel getChannel();

    ChannelFuture getFuture();
}
