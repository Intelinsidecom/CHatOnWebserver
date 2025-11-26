package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class DownstreamChannelStateEvent implements ChannelStateEvent {
    private final Channel channel;
    private final ChannelFuture future;
    private final ChannelState state;
    private final Object value;

    public DownstreamChannelStateEvent(Channel channel, ChannelFuture channelFuture, ChannelState channelState, Object obj) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        if (channelFuture == null) {
            throw new NullPointerException("future");
        }
        if (channelState == null) {
            throw new NullPointerException("state");
        }
        this.channel = channel;
        this.future = channelFuture;
        this.state = channelState;
        this.value = obj;
    }

    @Override // org.jboss.netty.channel.ChannelEvent
    public Channel getChannel() {
        return this.channel;
    }

    @Override // org.jboss.netty.channel.ChannelEvent
    public ChannelFuture getFuture() {
        return this.future;
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
                    sb.append(" CLOSE");
                    break;
                }
            case BOUND:
                if (getValue() != null) {
                    sb.append(" BIND: ");
                    sb.append(getValue());
                    break;
                } else {
                    sb.append(" UNBIND");
                    break;
                }
            case CONNECTED:
                if (getValue() != null) {
                    sb.append(" CONNECT: ");
                    sb.append(getValue());
                    break;
                } else {
                    sb.append(" DISCONNECT");
                    break;
                }
            case INTEREST_OPS:
                sb.append(" CHANGE_INTEREST: ");
                sb.append(getValue());
                break;
            default:
                sb.append(' ');
                sb.append(getState().name());
                sb.append(": ");
                sb.append(getValue());
                break;
        }
        return sb.toString();
    }
}
