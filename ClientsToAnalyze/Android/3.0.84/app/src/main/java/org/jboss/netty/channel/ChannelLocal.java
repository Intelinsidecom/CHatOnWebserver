package org.jboss.netty.channel;

import java.util.concurrent.ConcurrentMap;
import org.jboss.netty.util.internal.ConcurrentIdentityWeakKeyHashMap;

/* loaded from: classes.dex */
public class ChannelLocal<T> {
    private final ConcurrentMap<Channel, T> map = new ConcurrentIdentityWeakKeyHashMap();

    protected T initialValue(Channel channel) {
        return null;
    }

    public T get(Channel channel) {
        T ifAbsent;
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        T t = this.map.get(channel);
        if (t == null) {
            T tInitialValue = initialValue(channel);
            return (tInitialValue == null || (ifAbsent = setIfAbsent(channel, tInitialValue)) == null) ? tInitialValue : ifAbsent;
        }
        return t;
    }

    public T set(Channel channel, T t) {
        if (t == null) {
            return remove(channel);
        }
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        return this.map.put(channel, t);
    }

    public T setIfAbsent(Channel channel, T t) {
        if (t == null) {
            return get(channel);
        }
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        return this.map.putIfAbsent(channel, t);
    }

    public T remove(Channel channel) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        T tRemove = this.map.remove(channel);
        if (tRemove == null) {
            return initialValue(channel);
        }
        return tRemove;
    }
}
