package org.jboss.netty.channel;

import java.util.concurrent.ConcurrentMap;
import org.jboss.netty.util.internal.ConcurrentIdentityWeakKeyHashMap;

/* loaded from: classes.dex */
public class ChannelLocal {
    private final ConcurrentMap map;
    private final boolean removeOnClose;
    private final ChannelFutureListener remover;

    public ChannelLocal() {
        this(false);
    }

    public ChannelLocal(boolean z) {
        this.map = new ConcurrentIdentityWeakKeyHashMap();
        this.remover = new ChannelFutureListener() { // from class: org.jboss.netty.channel.ChannelLocal.1
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                ChannelLocal.this.remove(channelFuture.getChannel());
            }
        };
        this.removeOnClose = z;
    }

    protected Object initialValue(Channel channel) {
        return null;
    }

    public Object get(Channel channel) {
        Object ifAbsent;
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        Object obj = this.map.get(channel);
        if (obj == null) {
            Object objInitialValue = initialValue(channel);
            return (objInitialValue == null || (ifAbsent = setIfAbsent(channel, objInitialValue)) == null) ? objInitialValue : ifAbsent;
        }
        return obj;
    }

    public Object set(Channel channel, Object obj) {
        if (obj == null) {
            return remove(channel);
        }
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        Object objPut = this.map.put(channel, obj);
        if (this.removeOnClose) {
            channel.getCloseFuture().addListener(this.remover);
            return objPut;
        }
        return objPut;
    }

    public Object setIfAbsent(Channel channel, Object obj) {
        if (obj == null) {
            return get(channel);
        }
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        Object objPutIfAbsent = this.map.putIfAbsent(channel, obj);
        if (this.removeOnClose && objPutIfAbsent == null) {
            channel.getCloseFuture().addListener(this.remover);
            return objPutIfAbsent;
        }
        return objPutIfAbsent;
    }

    public Object remove(Channel channel) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        Object objRemove = this.map.remove(channel);
        if (objRemove == null) {
            return initialValue(channel);
        }
        if (this.removeOnClose) {
            channel.getCloseFuture().removeListener(this.remover);
            return objRemove;
        }
        return objRemove;
    }
}
