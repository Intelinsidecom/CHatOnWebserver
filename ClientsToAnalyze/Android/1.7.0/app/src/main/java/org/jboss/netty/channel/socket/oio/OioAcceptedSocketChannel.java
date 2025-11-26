package org.jboss.netty.channel.socket.oio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.Socket;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;

/* loaded from: classes.dex */
class OioAcceptedSocketChannel extends OioSocketChannel {

    /* renamed from: in */
    private final PushbackInputStream f5797in;
    private final OutputStream out;

    OioAcceptedSocketChannel(Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, Socket socket) {
        super(channel, channelFactory, channelPipeline, channelSink, socket);
        try {
            this.f5797in = new PushbackInputStream(socket.getInputStream(), 1);
            try {
                this.out = socket.getOutputStream();
                Channels.fireChannelOpen(this);
                Channels.fireChannelBound(this, getLocalAddress());
            } catch (IOException e) {
                throw new ChannelException("Failed to obtain an OutputStream.", e);
            }
        } catch (IOException e2) {
            throw new ChannelException("Failed to obtain an InputStream.", e2);
        }
    }

    @Override // org.jboss.netty.channel.socket.oio.OioSocketChannel
    PushbackInputStream getInputStream() {
        return this.f5797in;
    }

    @Override // org.jboss.netty.channel.socket.oio.OioSocketChannel
    OutputStream getOutputStream() {
        return this.out;
    }
}
