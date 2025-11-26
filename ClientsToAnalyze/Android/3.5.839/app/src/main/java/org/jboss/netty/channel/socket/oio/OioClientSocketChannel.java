package org.jboss.netty.channel.socket.oio;

import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.Socket;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;

/* loaded from: classes.dex */
class OioClientSocketChannel extends OioSocketChannel {

    /* renamed from: in */
    volatile PushbackInputStream f19097in;
    volatile OutputStream out;

    OioClientSocketChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        super(null, channelFactory, channelPipeline, channelSink, new Socket());
        Channels.fireChannelOpen(this);
    }

    @Override // org.jboss.netty.channel.socket.oio.OioSocketChannel
    PushbackInputStream getInputStream() {
        return this.f19097in;
    }

    @Override // org.jboss.netty.channel.socket.oio.OioSocketChannel
    OutputStream getOutputStream() {
        return this.out;
    }
}
