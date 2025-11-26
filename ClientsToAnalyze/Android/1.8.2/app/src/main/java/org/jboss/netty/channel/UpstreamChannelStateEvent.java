package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class UpstreamChannelStateEvent implements ChannelStateEvent {
    private final Channel channel;
    private final ChannelState state;
    private final Object value;

    public UpstreamChannelStateEvent(Channel channel, ChannelState channelState, Object obj) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        if (channelState == null) {
            throw new NullPointerException("state");
        }
        this.channel = channel;
        this.state = channelState;
        this.value = obj;
    }

    @Override // org.jboss.netty.channel.ChannelEvent
    public Channel getChannel() {
        return this.channel;
    }

    @Override // org.jboss.netty.channel.ChannelEvent
    public ChannelFuture getFuture() {
        return Channels.succeededFuture(getChannel());
    }

    @Override // org.jboss.netty.channel.ChannelStateEvent
    public ChannelState getState() {
        return this.state;
    }

    @Override // org.jboss.netty.channel.ChannelStateEvent
    public Object getValue() {
        return this.value;
    }

    public String toString() {
        String string = getChannel().toString();
        StringBuilder sb = new StringBuilder(string.length() + 64);
        sb.append(string);
        switch (getState()) {
            case OPEN:
                if (Boolean.TRUE.equals(getValue())) {
                    sb.append(" OPEN");
                    break;
                } else {
                    sb.append(" CLOSED");
                    break;
                }
            case BOUND:
                if (getValue() != null) {
                    sb.append(" BOUND: ");
                    sb.append(getValue());
                    break;
                } else {
                    sb.append(" UNBOUND");
                    break;
                }
            case CONNECTED:
                if (getValue() != null) {
                    sb.append(" CONNECTED: ");
                    sb.append(getValue());
                    break;
                } else {
                    sb.append(" DISCONNECTED");
                    break;
                }
            case INTEREST_OPS:
                sb.append(" INTEREST_CHANGED");
                break;
            default:
                sb.append(getState().name());
                sb.append(": ");
                sb.append(getValue());
                break;
        }
        return sb.toString();
    }
}
