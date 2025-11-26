package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class DefaultWriteCompletionEvent implements WriteCompletionEvent {
    private final Channel channel;
    private final long writtenAmount;

    public DefaultWriteCompletionEvent(Channel channel, long j) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        if (j <= 0) {
            throw new IllegalArgumentException("writtenAmount must be a positive integer: " + j);
        }
        this.channel = channel;
        this.writtenAmount = j;
    }

    @Override // org.jboss.netty.channel.ChannelEvent
    public Channel getChannel() {
        return this.channel;
    }

    @Override // org.jboss.netty.channel.ChannelEvent
    public ChannelFuture getFuture() {
        return Channels.succeededFuture(getChannel());
    }

    public long getWrittenAmount() {
        return this.writtenAmount;
    }

    public String toString() {
        String string = getChannel().toString();
        StringBuilder sb = new StringBuilder(string.length() + 32);
        sb.append(string);
        sb.append(" WRITTEN_AMOUNT: ");
        sb.append(getWrittenAmount());
        return sb.toString();
    }
}
