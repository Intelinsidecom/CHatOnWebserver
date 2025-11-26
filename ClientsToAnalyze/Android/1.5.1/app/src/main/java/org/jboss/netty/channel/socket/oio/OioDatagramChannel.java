package org.jboss.netty.channel.socket.oio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.DatagramChannelConfig;
import org.jboss.netty.channel.socket.DefaultDatagramChannelConfig;

/* loaded from: classes.dex */
final class OioDatagramChannel extends AbstractChannel implements DatagramChannel {
    private final DatagramChannelConfig config;
    final Object interestOpsLock;
    private volatile InetSocketAddress localAddress;
    volatile InetSocketAddress remoteAddress;
    final MulticastSocket socket;
    volatile Thread workerThread;

    OioDatagramChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        super(null, channelFactory, channelPipeline, channelSink);
        this.interestOpsLock = new Object();
        try {
            this.socket = new MulticastSocket((SocketAddress) null);
            try {
                this.socket.setSoTimeout(10);
                this.socket.setBroadcast(false);
                this.config = new DefaultDatagramChannelConfig(this.socket);
                Channels.fireChannelOpen(this);
            } catch (SocketException e) {
                throw new ChannelException("Failed to configure the datagram socket timeout.", e);
            }
        } catch (IOException e2) {
            throw new ChannelException("Failed to open a datagram socket.", e2);
        }
    }

    private void ensureBound() {
        if (!isBound()) {
            throw new IllegalStateException(DatagramChannel.class.getName() + " must be bound to join a group.");
        }
    }

    @Override // org.jboss.netty.channel.Channel
    public DatagramChannelConfig getConfig() {
        return this.config;
    }

    @Override // org.jboss.netty.channel.Channel
    public InetSocketAddress getLocalAddress() {
        InetSocketAddress inetSocketAddress = this.localAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.getLocalSocketAddress();
            this.localAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // org.jboss.netty.channel.Channel
    public InetSocketAddress getRemoteAddress() {
        InetSocketAddress inetSocketAddress = this.remoteAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.getRemoteSocketAddress();
            this.remoteAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isBound() {
        return isOpen() && this.socket.isBound();
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isConnected() {
        return isOpen() && this.socket.isConnected();
    }

    @Override // org.jboss.netty.channel.socket.DatagramChannel
    public void joinGroup(InetAddress inetAddress) throws IOException {
        ensureBound();
        try {
            this.socket.joinGroup(inetAddress);
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // org.jboss.netty.channel.socket.DatagramChannel
    public void joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) throws IOException {
        ensureBound();
        try {
            this.socket.joinGroup(inetSocketAddress, networkInterface);
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // org.jboss.netty.channel.socket.DatagramChannel
    public void leaveGroup(InetAddress inetAddress) throws IOException {
        try {
            this.socket.leaveGroup(inetAddress);
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // org.jboss.netty.channel.socket.DatagramChannel
    public void leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) throws IOException {
        try {
            this.socket.leaveGroup(inetSocketAddress, networkInterface);
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected boolean setClosed() {
        return super.setClosed();
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected void setInterestOpsNow(int i) {
        super.setInterestOpsNow(i);
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        return (socketAddress == null || socketAddress.equals(getRemoteAddress())) ? super.write(obj, null) : super.write(obj, socketAddress);
    }
}
