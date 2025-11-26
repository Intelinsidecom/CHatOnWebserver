package org.jboss.netty.bootstrap;

import java.net.SocketAddress;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipelineException;

/* loaded from: classes.dex */
public class ClientBootstrap extends Bootstrap {
    public ClientBootstrap() {
    }

    public ClientBootstrap(ChannelFactory channelFactory) {
        super(channelFactory);
    }

    public ChannelFuture connect() {
        SocketAddress socketAddress = (SocketAddress) getOption("remoteAddress");
        if (socketAddress == null) {
            throw new IllegalStateException("remoteAddress option is not set.");
        }
        return connect(socketAddress);
    }

    public ChannelFuture connect(SocketAddress socketAddress) {
        if (socketAddress == null) {
            throw new NullPointerException("remotedAddress");
        }
        return connect(socketAddress, (SocketAddress) getOption("localAddress"));
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        if (socketAddress == null) {
            throw new NullPointerException("remoteAddress");
        }
        try {
            Channel channelNewChannel = getFactory().newChannel(getPipelineFactory().getPipeline());
            channelNewChannel.getConfig().setOptions(getOptions());
            if (socketAddress2 != null) {
                channelNewChannel.bind(socketAddress2);
            }
            return channelNewChannel.connect(socketAddress);
        } catch (Exception e) {
            throw new ChannelPipelineException("Failed to initialize a pipeline.", e);
        }
    }
}
