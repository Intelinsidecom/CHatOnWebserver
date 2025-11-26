package org.jboss.netty.channel.group;

import java.util.EventListener;

/* loaded from: classes.dex */
public interface ChannelGroupFutureListener extends EventListener {
    void operationComplete(ChannelGroupFuture channelGroupFuture);
}
