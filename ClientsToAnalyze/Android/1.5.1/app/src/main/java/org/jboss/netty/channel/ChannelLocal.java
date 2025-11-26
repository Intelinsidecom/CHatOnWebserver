package org.jboss.netty.channel;

import java.util.concurrent.ConcurrentMap;
import org.jboss.netty.util.internal.ConcurrentIdentityWeakKeyHashMap;

/* loaded from: classes.dex */
public class ChannelLocal {
    private final ConcurrentMap map = new ConcurrentIdentityWeakKeyHashMap();

    public Object get(Channel channel) {
        Object ifAbsent;
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        Object obj = this.map.get(channel);
        if (obj != null) {
            return obj;
        }
        Object objInitialValue = initialValue(channel);
        return (objInitialValue == null || (ifAbsent = setIfAbsent(channel, objInitialValue)) == null) ? objInitialValue : ifAbsent;
    }

    protected Object initialValue(Channel channel) {
        return null;
    }

    public Object remove(Channel channel) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        return this.map.remove(channel);
    }

    public Object set(Channel channel, Object obj) {
        if (obj == null) {
            return remove(channel);
        }
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        return this.map.put(channel, obj);
    }

    public Object setIfAbsent(Channel channel, Object obj) {
        if (obj == null) {
            return get(channel);
        }
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        return this.map.putIfAbsent(channel, obj);
    }
}
