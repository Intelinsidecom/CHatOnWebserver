package org.jboss.netty.channel.local;

import org.jboss.netty.channel.Channel;

/* loaded from: classes.dex */
public interface LocalChannel extends Channel {
    @Override // org.jboss.netty.channel.Channel
    LocalAddress getLocalAddress();

    @Override // org.jboss.netty.channel.Channel
    LocalAddress getRemoteAddress();
}
