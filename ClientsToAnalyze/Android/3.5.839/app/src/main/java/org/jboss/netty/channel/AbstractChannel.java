package org.jboss.netty.channel;

import com.sec.chaton.privateplugin.data.Spam;
import java.net.SocketAddress;
import java.util.concurrent.ConcurrentMap;
import org.jboss.netty.util.internal.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class AbstractChannel implements Channel {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final ConcurrentMap<Integer, Channel> allChannels;
    private final ChannelFactory factory;
    private final Channel parent;
    private final ChannelPipeline pipeline;
    private String strVal;
    private boolean strValConnected;
    private final ChannelFuture succeededFuture = new SucceededChannelFuture(this);
    private final ChannelCloseFuture closeFuture = new ChannelCloseFuture();
    private volatile int interestOps = 1;

    /* renamed from: id */
    private final Integer f19091id = allocateId(this);

    static {
        $assertionsDisabled = !AbstractChannel.class.desiredAssertionStatus();
        allChannels = new ConcurrentHashMap();
    }

    private static Integer allocateId(Channel channel) {
        Integer numValueOf = Integer.valueOf(System.identityHashCode(channel));
        while (allChannels.putIfAbsent(numValueOf, channel) != null) {
            numValueOf = Integer.valueOf(numValueOf.intValue() + 1);
        }
        return numValueOf;
    }

    protected AbstractChannel(Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        this.parent = channel;
        this.factory = channelFactory;
        this.pipeline = channelPipeline;
        channelPipeline.attach(this, channelSink);
    }

    @Override // org.jboss.netty.channel.Channel
    public final Integer getId() {
        return this.f19091id;
    }

    @Override // org.jboss.netty.channel.Channel
    public Channel getParent() {
        return this.parent;
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelPipeline getPipeline() {
        return this.pipeline;
    }

    protected ChannelFuture getSucceededFuture() {
        return this.succeededFuture;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Channel channel) {
        return getId().compareTo(channel.getId());
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isOpen() {
        return !this.closeFuture.isDone();
    }

    protected boolean setClosed() {
        allChannels.remove(this.f19091id);
        return this.closeFuture.setClosed();
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture bind(SocketAddress socketAddress) {
        return Channels.bind(this, socketAddress);
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture close() {
        ChannelFuture channelFutureClose = Channels.close(this);
        if ($assertionsDisabled || this.closeFuture == channelFutureClose) {
            return this.closeFuture;
        }
        throw new AssertionError();
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture getCloseFuture() {
        return this.closeFuture;
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture connect(SocketAddress socketAddress) {
        return Channels.connect(this, socketAddress);
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture disconnect() {
        return Channels.disconnect(this);
    }

    public int getInterestOps() {
        return this.interestOps;
    }

    protected void setInterestOpsNow(int i) {
        this.interestOps = i;
    }

    public boolean isReadable() {
        return (getInterestOps() & 1) != 0;
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj) {
        return Channels.write(this, obj);
    }

    public String toString() {
        boolean zIsConnected = isConnected();
        if (this.strValConnected == zIsConnected && this.strVal != null) {
            return this.strVal;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("[id: 0x");
        sb.append(getIdString());
        SocketAddress localAddress = getLocalAddress();
        SocketAddress remoteAddress = getRemoteAddress();
        if (remoteAddress != null) {
            sb.append(", ");
            if (getParent() == null) {
                sb.append(localAddress);
                sb.append(zIsConnected ? " => " : " :> ");
                sb.append(remoteAddress);
            } else {
                sb.append(remoteAddress);
                sb.append(zIsConnected ? " => " : " :> ");
                sb.append(localAddress);
            }
        } else if (localAddress != null) {
            sb.append(", ");
            sb.append(localAddress);
        }
        sb.append(']');
        String string = sb.toString();
        this.strVal = string;
        this.strValConnected = zIsConnected;
        return string;
    }

    private String getIdString() {
        String hexString = Integer.toHexString(this.f19091id.intValue());
        switch (hexString.length()) {
            case 0:
                return "00000000";
            case 1:
                return "0000000" + hexString;
            case 2:
                return "000000" + hexString;
            case 3:
                return "00000" + hexString;
            case 4:
                return "0000" + hexString;
            case 5:
                return "000" + hexString;
            case 6:
                return "00" + hexString;
            case 7:
                return Spam.ACTIVITY_CANCEL + hexString;
            default:
                return hexString;
        }
    }

    final class ChannelCloseFuture extends DefaultChannelFuture {
        public ChannelCloseFuture() {
            super(AbstractChannel.this, false);
        }

        @Override // org.jboss.netty.channel.DefaultChannelFuture, org.jboss.netty.channel.ChannelFuture
        public boolean setSuccess() {
            return false;
        }

        @Override // org.jboss.netty.channel.DefaultChannelFuture, org.jboss.netty.channel.ChannelFuture
        public boolean setFailure(Throwable th) {
            return false;
        }

        boolean setClosed() {
            return super.setSuccess();
        }
    }
}
