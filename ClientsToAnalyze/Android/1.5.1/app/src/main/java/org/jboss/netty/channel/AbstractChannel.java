package org.jboss.netty.channel;

import java.net.SocketAddress;
import java.util.concurrent.ConcurrentMap;
import org.jboss.netty.util.internal.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class AbstractChannel implements Channel {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final IdDeallocator ID_DEALLOCATOR;
    static final ConcurrentMap allChannels;
    private final ChannelCloseFuture closeFuture;
    private final ChannelFactory factory;

    /* renamed from: id */
    private final Integer f4559id;
    private volatile int interestOps;
    private final Channel parent;
    private final ChannelPipeline pipeline;
    private String strVal;
    private boolean strValConnected;
    private final ChannelFuture succeededFuture;

    final class ChannelCloseFuture extends DefaultChannelFuture {
        public ChannelCloseFuture() {
            super(AbstractChannel.this, false);
        }

        boolean setClosed() {
            return super.setSuccess();
        }

        @Override // org.jboss.netty.channel.DefaultChannelFuture, org.jboss.netty.channel.ChannelFuture
        public boolean setFailure(Throwable th) {
            return false;
        }

        @Override // org.jboss.netty.channel.DefaultChannelFuture, org.jboss.netty.channel.ChannelFuture
        public boolean setSuccess() {
            return false;
        }
    }

    final class IdDeallocator implements ChannelFutureListener {
        IdDeallocator() {
        }

        @Override // org.jboss.netty.channel.ChannelFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            AbstractChannel.allChannels.remove(channelFuture.getChannel().getId());
        }
    }

    static {
        $assertionsDisabled = !AbstractChannel.class.desiredAssertionStatus();
        allChannels = new ConcurrentHashMap();
        ID_DEALLOCATOR = new IdDeallocator();
    }

    protected AbstractChannel(Integer num, Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        this.succeededFuture = new SucceededChannelFuture(this);
        this.closeFuture = new ChannelCloseFuture();
        this.interestOps = 1;
        this.f4559id = num;
        this.parent = channel;
        this.factory = channelFactory;
        this.pipeline = channelPipeline;
        channelPipeline.attach(this, channelSink);
    }

    protected AbstractChannel(Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        this.succeededFuture = new SucceededChannelFuture(this);
        this.closeFuture = new ChannelCloseFuture();
        this.interestOps = 1;
        this.parent = channel;
        this.factory = channelFactory;
        this.pipeline = channelPipeline;
        this.f4559id = allocateId(this);
        this.closeFuture.addListener(ID_DEALLOCATOR);
        channelPipeline.attach(this, channelSink);
    }

    private static Integer allocateId(Channel channel) {
        Integer numValueOf = Integer.valueOf(System.identityHashCode(channel));
        while (allChannels.putIfAbsent(numValueOf, channel) != null) {
            numValueOf = Integer.valueOf(numValueOf.intValue() + 1);
        }
        return numValueOf;
    }

    private String getIdString() {
        String hexString = Integer.toHexString(this.f4559id.intValue());
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
                return "0" + hexString;
            default:
                return hexString;
        }
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

    @Override // java.lang.Comparable
    public final int compareTo(Channel channel) {
        return getId().compareTo(channel.getId());
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture connect(SocketAddress socketAddress) {
        return Channels.connect(this, socketAddress);
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture disconnect() {
        return Channels.disconnect(this);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture getCloseFuture() {
        return this.closeFuture;
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFactory getFactory() {
        return this.factory;
    }

    @Override // org.jboss.netty.channel.Channel
    public final Integer getId() {
        return this.f4559id;
    }

    @Override // org.jboss.netty.channel.Channel
    public int getInterestOps() {
        return this.interestOps;
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

    protected ChannelFuture getUnsupportedOperationFuture() {
        return new FailedChannelFuture(this, new UnsupportedOperationException());
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isOpen() {
        return !this.closeFuture.isDone();
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isReadable() {
        return (getInterestOps() & 1) != 0;
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isWritable() {
        return (getInterestOps() & 4) == 0;
    }

    protected boolean setClosed() {
        return this.closeFuture.setClosed();
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture setInterestOps(int i) {
        return Channels.setInterestOps(this, i);
    }

    protected void setInterestOpsNow(int i) {
        this.interestOps = i;
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture setReadable(boolean z) {
        return z ? setInterestOps(getInterestOps() | 1) : setInterestOps(getInterestOps() & (-2));
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

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture unbind() {
        return Channels.unbind(this);
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj) {
        return Channels.write(this, obj);
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        return Channels.write(this, obj, socketAddress);
    }
}
