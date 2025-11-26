package org.jboss.netty.channel.socket.oio;

import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.socket.DefaultSocketChannelConfig;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.channel.socket.SocketChannelConfig;

/* loaded from: classes.dex */
abstract class OioSocketChannel extends AbstractChannel implements SocketChannel {
    private final SocketChannelConfig config;
    final Object interestOpsLock;
    private volatile InetSocketAddress localAddress;
    private volatile InetSocketAddress remoteAddress;
    final Socket socket;
    volatile Thread workerThread;

    abstract PushbackInputStream getInputStream();

    abstract OutputStream getOutputStream();

    OioSocketChannel(Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, Socket socket) {
        super(channel, channelFactory, channelPipeline, channelSink);
        this.interestOpsLock = new Object();
        this.socket = socket;
        this.config = new DefaultSocketChannelConfig(socket);
    }

    @Override // org.jboss.netty.channel.Channel
    public SocketChannelConfig getConfig() {
        return this.config;
    }

    @Override // org.jboss.netty.channel.Channel
    public InetSocketAddress getLocalAddress() {
        InetSocketAddress inetSocketAddress = this.localAddress;
        if (inetSocketAddress == null) {
            try {
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.getLocalSocketAddress();
                this.localAddress = inetSocketAddress2;
                return inetSocketAddress2;
            } catch (Throwable th) {
                return null;
            }
        }
        return inetSocketAddress;
    }

    @Override // org.jboss.netty.channel.Channel
    public InetSocketAddress getRemoteAddress() {
        InetSocketAddress inetSocketAddress = this.remoteAddress;
        if (inetSocketAddress == null) {
            try {
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.getRemoteSocketAddress();
                this.remoteAddress = inetSocketAddress2;
                return inetSocketAddress2;
            } catch (Throwable th) {
                return null;
            }
        }
        return inetSocketAddress;
    }

    public boolean isBound() {
        return isOpen() && this.socket.isBound();
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isConnected() {
        return isOpen() && this.socket.isConnected();
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected boolean setClosed() {
        return super.setClosed();
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected void setInterestOpsNow(int i) {
        super.setInterestOpsNow(i);
    }
}
