package org.jboss.netty.channel.group;

import java.util.Set;
import org.jboss.netty.channel.Channel;

/* loaded from: classes.dex */
public interface ChannelGroup extends Comparable<ChannelGroup>, Set<Channel> {
    ChannelGroupFuture close();

    String getName();

    ChannelGroupFuture write(Object obj);
}
