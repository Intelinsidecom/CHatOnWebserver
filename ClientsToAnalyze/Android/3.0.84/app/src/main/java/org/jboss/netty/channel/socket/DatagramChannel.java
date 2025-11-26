package org.jboss.netty.channel.socket;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import org.jboss.netty.channel.Channel;

/* loaded from: classes.dex */
public interface DatagramChannel extends Channel {
    @Override // org.jboss.netty.channel.Channel
    DatagramChannelConfig getConfig();

    @Override // org.jboss.netty.channel.Channel
    InetSocketAddress getLocalAddress();

    @Override // org.jboss.netty.channel.Channel
    InetSocketAddress getRemoteAddress();

    void joinGroup(InetAddress inetAddress);

    void joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface);

    void leaveGroup(InetAddress inetAddress);

    void leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface);
}
