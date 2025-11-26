package org.jboss.netty.channel.group;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ServerChannel;
import org.jboss.netty.util.internal.ConcurrentHashMap;

/* loaded from: classes.dex */
public class DefaultChannelGroup extends AbstractSet<Channel> implements ChannelGroup {
    private static final AtomicInteger nextId = new AtomicInteger();
    private final String name;
    private final ConcurrentMap<Integer, Channel> nonServerChannels;
    private final ChannelFutureListener remover;
    private final ConcurrentMap<Integer, Channel> serverChannels;

    public DefaultChannelGroup() {
        this("group-0x" + Integer.toHexString(nextId.incrementAndGet()));
    }

    public DefaultChannelGroup(String str) {
        this.serverChannels = new ConcurrentHashMap();
        this.nonServerChannels = new ConcurrentHashMap();
        this.remover = new ChannelFutureListener() { // from class: org.jboss.netty.channel.group.DefaultChannelGroup.1
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                DefaultChannelGroup.this.remove(channelFuture.getChannel());
            }
        };
        if (str == null) {
            throw new NullPointerException("name");
        }
        this.name = str;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroup
    public String getName() {
        return this.name;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.nonServerChannels.isEmpty() && this.serverChannels.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.nonServerChannels.size() + this.serverChannels.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return this.nonServerChannels.containsKey(obj) || this.serverChannels.containsKey(obj);
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        if (obj instanceof ServerChannel) {
            return this.serverChannels.containsKey(channel.getId());
        }
        return this.nonServerChannels.containsKey(channel.getId());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Channel channel) {
        boolean z = (channel instanceof ServerChannel ? this.serverChannels : this.nonServerChannels).putIfAbsent(channel.getId(), channel) == null;
        if (z) {
            channel.getCloseFuture().addListener(this.remover);
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Channel channelRemove = null;
        if (obj instanceof Integer) {
            channelRemove = this.nonServerChannels.remove(obj);
            if (channelRemove == null) {
                channelRemove = this.serverChannels.remove(obj);
            }
        } else if (obj instanceof Channel) {
            Channel channel = (Channel) obj;
            if (channel instanceof ServerChannel) {
                channelRemove = this.serverChannels.remove(channel.getId());
            } else {
                channelRemove = this.nonServerChannels.remove(channel.getId());
            }
        }
        if (channelRemove == null) {
            return false;
        }
        channelRemove.getCloseFuture().removeListener(this.remover);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.nonServerChannels.clear();
        this.serverChannels.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Channel> iterator() {
        return new CombinedIterator(this.serverChannels.values().iterator(), this.nonServerChannels.values().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ArrayList arrayList = new ArrayList(size());
        arrayList.addAll(this.serverChannels.values());
        arrayList.addAll(this.nonServerChannels.values());
        return arrayList.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        ArrayList arrayList = new ArrayList(size());
        arrayList.addAll(this.serverChannels.values());
        arrayList.addAll(this.nonServerChannels.values());
        return (T[]) arrayList.toArray(tArr);
    }

    @Override // org.jboss.netty.channel.group.ChannelGroup
    public ChannelGroupFuture close() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            linkedHashMap.put(channel.getId(), channel.close().awaitUninterruptibly());
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            linkedHashMap.put(channel2.getId(), channel2.close());
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap);
    }

    @Override // org.jboss.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        if (obj instanceof ChannelBuffer) {
            ChannelBuffer channelBuffer = (ChannelBuffer) obj;
            for (Channel channel : this.nonServerChannels.values()) {
                linkedHashMap.put(channel.getId(), channel.write(channelBuffer.duplicate()));
            }
        } else {
            for (Channel channel2 : this.nonServerChannels.values()) {
                linkedHashMap.put(channel2.getId(), channel2.write(obj));
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelGroup channelGroup) {
        int iCompareTo = getName().compareTo(channelGroup.getName());
        return iCompareTo != 0 ? iCompareTo : System.identityHashCode(this) - System.identityHashCode(channelGroup);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getSimpleName() + "(name: " + getName() + ", size: " + size() + ')';
    }
}
